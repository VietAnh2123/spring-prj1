package com.anhnhv.restfulwebservices.project.service;

import com.anhnhv.restfulwebservices.project.dto.UserDTO;
import com.anhnhv.restfulwebservices.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUserById(Long id);
}
