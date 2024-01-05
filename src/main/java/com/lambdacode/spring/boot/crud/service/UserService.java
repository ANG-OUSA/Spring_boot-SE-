package com.lambdacode.spring.boot.crud.service;

import com.lambdacode.spring.boot.crud.dto.UserDTO;
import com.lambdacode.spring.boot.crud.entity.Users;

import java.util.List;

public interface UserService {
    void addUser(Users user);

    List<Users> getUsers();

    Users getUser(Integer id);

    void updateUser(Integer id, Users user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}
