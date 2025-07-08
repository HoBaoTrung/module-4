package com.codegym.blogapp.service;

import com.codegym.blogapp.model.User;
import com.codegym.blogapp.model.UserPrinciple;
import com.codegym.blogapp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);

        if (user != null) {
            return UserPrinciple.build(user);
        }
        return null;
    }
}
