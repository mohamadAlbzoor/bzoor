package com.example.bzoor;

import com.example.bzoor.models.MyUserDetails;
import com.example.bzoor.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService{

    final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("MyUserDetailsService -- loading user by user name");
        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException(("Not found: " + username)));
        return user.map(MyUserDetails::new).get();
    }
}
