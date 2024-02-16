package com.anhnhv.restfulwebservices.project.mapper;

import com.anhnhv.restfulwebservices.project.dto.UserDTO;
import com.anhnhv.restfulwebservices.project.model.User;

public class UserMapper {
    //convert user jpa entity to userdto
    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getAddress(),
                user.getEmail()
        );
        return userDTO;
    }

    //convert userdto to user jpa entity
    public static User mapToUser(UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getAge(),
                userDTO.getAddress(),
                userDTO.getEmail()
        );
        return user;
    }
}
