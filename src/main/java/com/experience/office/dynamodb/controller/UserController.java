package com.experience.office.dynamodb.controller;


import com.experience.office.dynamodb.dto.UserDTO;
import com.experience.office.dynamodb.model.User;
import com.experience.office.dynamodb.service.UserService;
import com.experience.office.dynamodb.utils.UserBuilder;
import com.experience.office.dynamodb.utils.UserBuilderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<UserDTO> getAllUsers(@PathVariable String id) {
        List<User> users = service.findAll();

        if (users == null) {
            return ResponseEntity.noContent().build();
        }

        //List<UserDTO> allUsers = users.stream().forEach(c -> c User::UserBuilderDTO.from(c))

        //return ResponseEntity.ok(UserBuilderDTO.from(user));
        return null;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        User user = service.findUserById(id);

        if (user == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(UserBuilderDTO.from(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        ;

        User respose = service.saveUser(UserBuilder.from(userDTO));
        if (respose.getId() == null) {
            return ResponseEntity.badRequest().body(userDTO);
        }
        return ResponseEntity.ok(UserBuilderDTO.from(respose));
    }

    @DeleteMapping
    public ResponseEntity<UserDTO> deleteUser(UserDTO userDTO) {

        service.deleteUser(UserBuilder.from(userDTO));
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(UserDTO userDTO) {
        ;

        User respose = service.saveUser(UserBuilder.from(userDTO));
        if (respose.getId() == null) {
            return ResponseEntity.badRequest().body(userDTO);
        }
        return ResponseEntity.ok(UserBuilderDTO.from(respose));
    }

}
