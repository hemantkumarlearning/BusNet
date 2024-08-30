package com.hemant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminId;

    @NotNull(message = "This Field can not be null..")
    @NotBlank(message = "This Field can not be blank..")
    @NotEmpty(message = "This Field can not be empty..")
    private String adminUserName;

    @NotNull(message = "This Field can not be null..")
    @NotBlank(message = "This Field can not be blank..")
    @NotEmpty(message = "This Field can not be empty..")
    private String adminPassword;
}
