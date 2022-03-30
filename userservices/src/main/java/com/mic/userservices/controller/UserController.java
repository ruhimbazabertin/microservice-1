package com.mic.userservices.controller;

import com.mic.userservices.VO.ResponseTemplateVO;
import com.mic.userservices.data.User;
import com.mic.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    private User createUser(@RequestBody User user){

        return userService.createUser(user);
    }
    @RequestMapping("/{id}")
    private ResponseTemplateVO findUserWithDepart(@PathVariable("id") Long id){

        return userService.getUserWithDepart(id);
    }
}
