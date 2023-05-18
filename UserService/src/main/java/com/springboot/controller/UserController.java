package com.springboot.controller;

import com.springboot.WrapperObject.Department;
import com.springboot.WrapperObject.ResponseTemplate;
import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplate getUser(@PathVariable Long id){
        return  userService.getUser(id);
    }
    @PostMapping("/dep")
    public Department saveDep(){
        return  userService.saveDep();
    }
    @PostMapping("/userdep")
    public ResponseTemplate saveBoth(@RequestBody ResponseTemplate responseTemplate){
        return  userService.saveBoth(responseTemplate);
    }
}
