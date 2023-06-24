package com.sample.demo.repo;

import com.sample.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> { //User is Entity name, Integer is primary key data type

    @Query(value= "SELECT * from USER WHERE ID=?1",nativeQuery = true) //?1 mean first argument in method
    User getUserByUserID(String userId);

    @Query(value="SELECT * from USER WHERE ID=?1 AND ADDRESS=?2",nativeQuery = true )
    User getUserByAddress(String userId,String address);

   // @Modifying use for updating
    @Modifying
    @Query(value="UPDATE * from USER WHERE ID=?1",nativeQuery = true)
    User updateUserByID(String userId);

}
