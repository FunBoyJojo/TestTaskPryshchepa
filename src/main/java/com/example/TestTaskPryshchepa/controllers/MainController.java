package com.example.TestTaskPryshchepa.controllers;

import com.example.TestTaskPryshchepa.models.User;
import com.example.TestTaskPryshchepa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class MainController {

    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.getUserByID(id);
    }

}