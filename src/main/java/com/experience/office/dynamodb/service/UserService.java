package com.experience.office.dynamodb.service;

import com.experience.office.dynamodb.model.User;

import java.util.List;

public interface UserService {

    User findUserById(String id);
    User saveUser(User user);
    void deleteUser(User user);
    User updateUser(User user);
    List<User> findAll();
}
