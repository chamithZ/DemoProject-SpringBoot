package com.sample.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor //lombok
@AllArgsConstructor
@Data

public class User {
    @Id
    private int id;
    private String name;
    private String address;

}
