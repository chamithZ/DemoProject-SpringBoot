package com.sample.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sample.demo.dto.UserDTO;
import com.sample.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping(value= "api/v1/user")
@CrossOrigin

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){  // RequestBody annotation use to convert json to java userDTO object
        return userService.saveUser(userDTO); //call saveUser method in UserService class and pass userDTO object
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping ("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUser/{userID}")
    public UserDTO getUserById(@PathVariable String userID){
        return userService.getUserById(userID);
    }

    @GetMapping("/getUserByAddress/{userID}/{address}")
    public UserDTO getUserByAddress(@PathVariable String userID,@PathVariable String address){

        return userService.getUserByAddress(userID,address);
    }

    @PutMapping("update/{id}")
    public UserDTO updateUserById(@PathVariable("id") String userId,
                                                  @RequestBody UserDTO updatedUserDTO) {
        UserDTO updatedUser = userService.updateUserById(userId, updatedUserDTO);
        return updatedUser;
    }
}
