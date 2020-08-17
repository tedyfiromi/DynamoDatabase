package com.experience.office.dynamodb.service.impl;

import com.experience.office.dynamodb.model.User;
import com.experience.office.dynamodb.repository.UserRepository;
import com.experience.office.dynamodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public User findUserById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        repository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

}
