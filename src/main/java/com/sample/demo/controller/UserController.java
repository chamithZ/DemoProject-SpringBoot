package com.sample.demo.controller;

import com.sample.demo.dto.UserDTO;
import com.sample.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "api/v1/user")
@CrossOrigin

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser(){
        return "Hehe";
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){  // RequestBody annotation use to convert json to java userDTO object
        return userService.saveUser(userDTO); //call saveUser method in UserService class and pass userDTO object
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "User updated";
    }

    @DeleteMapping ("/deleteUser")
    public String deleteUser(){
        return "User deleted";
    }


}
