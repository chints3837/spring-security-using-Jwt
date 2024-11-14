package com.example.SpringbootSecurity.controller;

import com.example.SpringbootSecurity.model.Users;
import com.example.SpringbootSecurity.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;


    @PostMapping("/register")
    public Users reisterUser(@RequestBody Users users)
    {

        Users result=usersService.registerUser(users);
        return result;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        System.out.println(users.getUsername()+" "+users.getPassword());

        return usersService.verify(users);
    }
}
