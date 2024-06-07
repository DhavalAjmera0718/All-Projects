package com.DemoOld_Security.Implimantation;

import org.springframework.stereotype.Component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.DemoOld_Security.Entity.JWT_Entity;
import com.DemoOld_Security.Repository.JWT_Repooo;

@Service
public class Implimantation implements UserDetailsService {

    @Autowired
    private JWT_Repooo userRepository;  // Assuming you have a UserRepository interface

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user details from your database
         Optional<JWT_Entity> userEntityOptional = userRepository.findById(username);

        if (userEntityOptional.isPresent()) {
        	JWT_Entity userEntity = userEntityOptional.get();

            // Build UserDetails using fetched user details
            return User.builder()
                    .username(userEntity.getUserName())
                    .password(passwordEncoder.encode(userEntity.getPassWord()))
                    // Adjust this based on your user entity structure
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
