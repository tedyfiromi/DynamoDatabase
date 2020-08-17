package com.experience.office.dynamodb.controller;


import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.experience.office.dynamodb.dto.UserDTO;
import com.experience.office.dynamodb.model.User;
import com.experience.office.dynamodb.service.UserService;
import com.experience.office.dynamodb.utils.UserBuilder;
import com.experience.office.dynamodb.utils.UserBuilderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {

        try {
            User user = service.findUserById(id);
            if (user == null) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(UserBuilderDTO.from(user));

        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        try {
            User user = service.saveUser(UserBuilder.from(userDTO));
            return ResponseEntity.ok(UserBuilderDTO.from(user));

        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String userId) {

        try {
            service.deleteUser(userId);
            return ResponseEntity.noContent().build();

        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {

        try {
            User respose = service.saveUser(UserBuilder.from(userDTO));
            return ResponseEntity.ok(UserBuilderDTO.from(respose));

        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
