package com.hemant.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private Long contact;


    @Size(min = 6,max = 12,message = "size should be between 6 to 12 characters..")
    private String password;
}
