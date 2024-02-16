package com.anhnhv.restfulwebservices.project.service.impl;

import com.anhnhv.restfulwebservices.project.dto.UserDTO;
import com.anhnhv.restfulwebservices.project.exception.EmailAlreadyExistsException;
import com.anhnhv.restfulwebservices.project.exception.ResourceNotFoundException;
import com.anhnhv.restfulwebservices.project.mapper.AutoUserMapper;
import com.anhnhv.restfulwebservices.project.mapper.UserMapper;
import com.anhnhv.restfulwebservices.project.model.User;
import com.anhnhv.restfulwebservices.project.repository.UserRepository;
import com.anhnhv.restfulwebservices.project.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //convert userdto to user jpa entity
        //User u = UserMapper.mapToUser(userDTO);

        //User user = modelMapper.map(userDTO, User.class);

        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email already existed!");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDTO);

        User savedUser = userRepository.save(user);

        //convert user jpa entity to userdto
        //UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);

        //UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);

        UserDTO savedUserDTO = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User getUser = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User", "id", id)
        );
//        User user = getUser.get();
        //return UserMapper.mapToUserDTO(user);
        //return modelMapper.map(user, UserDTO.class); //map user có kiểu dữ liệu User thành UserDTO
        return AutoUserMapper.MAPPER.mapToUserDto(getUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();
        //return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
        //return users.stream().map((user) -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList();
        return users.stream().map(user -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existedUSer = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", user.getId())
        );
        existedUSer.setName(user.getName());
        existedUSer.setAge(user.getAge());
        existedUSer.setAddress(user.getAddress());
        existedUSer.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existedUSer);

        //return UserMapper.mapToUserDTO(updatedUser);
        //return modelMapper.map(updatedUser, UserDTO.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {

        User existedUSer = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", id)
        );

        userRepository.deleteById(id);
    }


}
