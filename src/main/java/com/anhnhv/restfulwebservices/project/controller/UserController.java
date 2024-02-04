package com.anhnhv.restfulwebservices.project.controller;

import com.anhnhv.restfulwebservices.project.dto.UserDTO;
import com.anhnhv.restfulwebservices.project.model.User;
import com.anhnhv.restfulwebservices.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<UserDTO> getUserById(@RequestParam(name = "id") Long id){

        UserDTO u = userService.getUserById(id);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(name = "id")Long id,@RequestBody UserDTO user){
        user.setId(id);
        UserDTO updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam(name = "id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
