package com.experience.office.dynamodb.utils;

import com.experience.office.dynamodb.dto.UserDTO;
import com.experience.office.dynamodb.model.User;

public abstract class UserBuilderDTO {

    public static UserDTO from(User user) {

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }


}
