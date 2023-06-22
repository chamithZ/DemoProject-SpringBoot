package com.sample.demo.service;

import com.sample.demo.dto.UserDTO;
import com.sample.demo.entity.User;
import com.sample.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;


    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class)); // modelMapper convert userDTO object to User object
        return userDTO;
    }
}
