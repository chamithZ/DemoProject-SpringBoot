package com.sample.demo.repo;

import com.sample.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> { //User is Entity name, Integer is primary key data type


}
