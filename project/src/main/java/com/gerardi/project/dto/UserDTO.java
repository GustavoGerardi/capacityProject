package com.gerardi.project.dto;

import com.gerardi.project.entities.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String name;

    public UserDTO(User user) {
        this.name = user.getName();
    }
}
