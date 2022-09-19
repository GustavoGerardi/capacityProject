package com.gerardi.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonIgnore
    private Integer id;

    private String name;
    private String email;

    @JsonIgnore
    private String password;
}