package com.example.SpringbootSecurity.controller;

import com.example.SpringbootSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentContoller {


    public List<Student> students= new ArrayList<>(List.of(
            new Student(1,"Prajwal",450),
            new Student(2,"Atul",500)
    ));

    @GetMapping("/Students")
    public List<Student> getStudent()
    {
        return students;
    }

    @PostMapping("/Students")
    public Student addStudent(@RequestBody Student student)
    {
        students.add(student);
        return student;
    }

    @GetMapping("/getCsrfToken")
    public CsrfToken gettoken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
