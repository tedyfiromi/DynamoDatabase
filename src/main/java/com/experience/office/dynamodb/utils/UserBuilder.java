package com.experience.office.dynamodb.utils;

import com.experience.office.dynamodb.dto.UserDTO;
import com.experience.office.dynamodb.model.User;

public abstract class UserBuilder {

    public static User from(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .build();
    }
}
