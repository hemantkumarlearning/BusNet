package com.hemant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer busId;

    @NotNull(message = "Bus Name can not be null..")
    @NotBlank(message = "Bus Name can not be blank..")
    @NotEmpty(message = "Bus Name can not be empty..")
    private String busName;

    @NotNull(message = "Driver Name can not be null..")
    @NotBlank(message = "Driver Name can not be blank..")
    @NotEmpty(message = "Driver Name can not be empty..")
    private String driverName;

    @NotNull(message = "Bus Type can not be null..")
    @NotBlank(message = "Bus Type can not be blank..")
    @NotEmpty(message = "Bus Type can not be empty..")
    private String busType;

    @NotNull(message = "This Field can not be null..")
    @NotBlank(message = "This Field can not be blank..")
    @NotEmpty(message = "This Field can not be empty..")
    private String routeFrom;

    @NotNull(message = "This Field can not be null..")
    @NotBlank(message = "This Field can not be blank..")
    @NotEmpty(message = "This Field can not be empty..")
    private String routeTo;

    private LocalTime arrivalTime;

    private LocalTime departureTime;

    private Integer farePerSeat;


    @Min(value = 1)
    @Max(value = 60)

    private Integer seats;

    private Integer availableSeats;

    @JsonIgnore
    @ManyToOne
    private Route route;

}
