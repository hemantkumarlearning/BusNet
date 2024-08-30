package com.hemant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;


    private String reservationStatus;

    @NotNull(message = "This Field can not be null..")
    private String reservationType;

    private LocalDate reservationDate;

    private LocalDate journeyDate;

    private LocalTime reservationTime;

    @NotNull(message = "This Field can not be null..")
    private String source;

    @NotNull(message = "This Field can not be null..")
    private String destination;

    private Integer noOfSeatsBooked;

    private Integer fare;



    @ManyToOne
    @JoinColumn( name = "bus_id", referencedColumnName = "busId")
    private Bus bus;

    @ManyToOne
    @JoinColumn( name = "user_id", referencedColumnName = "userLoginId")
    private User user;
}
