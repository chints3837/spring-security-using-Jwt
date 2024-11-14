package com.example.SpringbootSecurity.controller;

import com.example.SpringbootSecurity.model.Users;
import com.example.SpringbootSecurity.repository.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HelloController {


    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String getMessage(HttpServletRequest request)
    {
        System.out.println("Session Id is :"+request.getSession().getId());
        return "Hello World"+"Session id :"+request.getSession().getId();
    }


    @GetMapping("/getname")
    public Users getname()
    {
        Users users=userRepo.findByUsername("Prajwal");

        if(users==null)
        {
            System.out.println("User not found");
            return null;
        }
        return users;
    }

}
