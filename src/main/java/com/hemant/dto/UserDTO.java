package com.hemant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
}
