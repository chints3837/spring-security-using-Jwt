package com.example.SpringbootSecurity.service;

import com.example.SpringbootSecurity.model.UserPrincipal;
import com.example.SpringbootSecurity.model.Users;
import com.example.SpringbootSecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user=userRepo.findByUsername(username);

        if(user == null)
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);

    }
}
