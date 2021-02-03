package vn.codegym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import vn.codegym.Service.Impl.MyUserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/customer/loginForm")
                .defaultSuccessUrl("/customer/home")
                .failureUrl("/customer/loginForm?error=true")
                .permitAll()
                .and()
                .logout().deleteCookies()
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/customer/home", "/css/bootstrap.css", "/css/main.css", "/img/*").permitAll()
                .antMatchers("/customer/create").hasRole("ADMIN")
                .antMatchers("/customer/edit/{id}").hasRole("ADMIN")
                .antMatchers("/employee/createEmployee").hasRole("ADMIN")
                .antMatchers("/employee/edit/{id}").hasRole("ADMIN")
                .antMatchers("/employee/delete/{id}").hasRole("ADMIN")
                .antMatchers("/customer/delete/{id}").hasRole("ADMIN")
                .antMatchers("/service/createService").hasRole("ADMIN")
                .antMatchers("/service/edit/{id}").hasRole("ADMIN")
                .antMatchers("/service/delete/{id}").hasRole("ADMIN")
                .antMatchers("/contract/create").hasRole("ADMIN")
                .antMatchers("/contract/edit/{id}").hasRole("ADMIN")
                .antMatchers("/contract/delete/{id}").hasRole("ADMIN")
                .anyRequest().authenticated();
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/customer/403");


        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl(); // Ta lưu tạm remember me trong memory (RAM). Nếu cần mình có thể lưu trong database
        return memory;
    }


//
//    public static void main(String[] args) {
//        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//        String pass=bCryptPasswordEncoder.encode("123");
//        System.out.println("pass:     "+pass);
//    }
}
