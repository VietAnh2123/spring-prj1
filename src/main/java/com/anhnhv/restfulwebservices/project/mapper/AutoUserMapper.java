package com.anhnhv.restfulwebservices.project.mapper;

import com.anhnhv.restfulwebservices.project.dto.UserDTO;
import com.anhnhv.restfulwebservices.project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    //@Mapping(source = "email", target = "emailAddress") use this annotation when have a difference attribute name
    UserDTO mapToUserDto(User user);

    User mapToUser(UserDTO userDTO);

}
