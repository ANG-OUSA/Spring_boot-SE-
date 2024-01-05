package com.lambdacode.spring.boot.crud.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private Integer userId;
    private String email;
    private Integer password;
    private String userType;
}

