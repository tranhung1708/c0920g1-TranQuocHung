package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.model.MyUserDetail;
import vn.codegym.model.User;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.repository.UserRepository;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findAllByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("user name not found: " + s);
        }
        return new MyUserDetail(user);
    }
}
