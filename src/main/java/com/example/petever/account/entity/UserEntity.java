package com.example.petever.account.entity;

import javax.persistence.Id;

public class UserEntity {

    @Id
    private String email;
    private String password;
    private String name;
}
