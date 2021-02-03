package vn.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.repository.CustomerRepositoryImpl;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerServiecImpl;

@SpringBootApplication
public class ThuchanhApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThuchanhApplication.class, args);
    }
    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiecImpl();
    }
}
