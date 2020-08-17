package com.experience.office.dynamodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

}
