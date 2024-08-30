package com.hemant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;

    @NotNull(message = "This Field can not be null..")
    @NotBlank(message = "This Field can not be blank..")
    @NotEmpty(message = "This Field can not be empty..")
    private String  routeFrom;

    @NotNull(message = "This Field can not be null..")
    @NotBlank(message = "This Field can not be blank..")
    @NotEmpty(message = "This Field can not be empty..")
    private String routeTo;

    private Integer distance;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private List<Bus> bus;
}
