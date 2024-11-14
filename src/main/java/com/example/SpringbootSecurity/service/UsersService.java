package com.example.SpringbootSecurity.service;

import com.example.SpringbootSecurity.model.Users;
import com.example.SpringbootSecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public Users registerUser(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        Users result = userRepo.save(users);
        return result;
    }

    public String verify(Users users) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(users.getUsername());
        } else {
            return "fail";

        }

    }
}
