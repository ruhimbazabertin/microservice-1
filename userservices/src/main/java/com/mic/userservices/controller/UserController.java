package com.mic.userservices.controller;

import com.mic.userservices.VO.ResponseTemplateVO;
import com.mic.userservices.data.User;
import com.mic.userservices.service.UserService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    int count = 1;
    @RequestMapping("/{id}")
    private ResponseTemplateVO findUserWithDepart(@PathVariable("id") Long id){

        return userService.getUserWithDepart(id);
    }
}
