package com.anhnhv.restfulwebservices.project.service.impl;

import com.anhnhv.restfulwebservices.project.dto.UserDTO;
import com.anhnhv.restfulwebservices.project.mapper.UserMapper;
import com.anhnhv.restfulwebservices.project.model.User;
import com.anhnhv.restfulwebservices.project.repository.UserRepository;
import com.anhnhv.restfulwebservices.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //convert userdto to user jpa entity
        User u = UserMapper.mapToUser(userDTO);

        User savedUser = userRepository.save(u);

        //convert user jpa entity to userdto
        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);

        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> getUser = userRepository.findById(id);
        User user = getUser.get();
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existedUSer = userRepository.findById(user.getId()).get();
        existedUSer.setName(user.getName());
        existedUSer.setAge(user.getAge());
        existedUSer.setAddress(user.getAddress());
        existedUSer.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existedUSer);

        return UserMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
