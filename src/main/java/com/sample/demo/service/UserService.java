package com.sample.demo.service;

import com.sample.demo.dto.UserDTO;
import com.sample.demo.entity.User;
import com.sample.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }
    public UserDTO getUserById(String userID){
        User user=userRepo.getUserByUserID(userID);
        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO getUserByAddress(String userID,String address){
        User user= userRepo.getUserByAddress(userID,address);
        return modelMapper.map(user,UserDTO.class);
    }
    public UserDTO updateUserById(String userID){
        User user =userRepo.updateUserByID(userID);
        return modelMapper.map(user,UserDTO.class);
    }



    public UserDTO updateUserById(String userID, UserDTO updatedUserDTO) {
        User existingUser = userRepo.getUserByUserID(userID);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found with ID: " + userID);
        }

        // Update the properties of the existing user with the values from updatedUserDTO
        existingUser.setName(updatedUserDTO.getName());
        existingUser.setAddress(updatedUserDTO.getAddress());
        // Update other properties accordingly

        // Save the updated user
        User updatedUser = userRepo.save(existingUser);

        return modelMapper.map(updatedUser, UserDTO.class);
    }


}
