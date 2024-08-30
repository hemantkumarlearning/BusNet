package com.hemant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedbackId;
    private Integer driverRating;
    private Integer serviceRating;
    private Integer overallRating;
    private String comments;
    private LocalDate feedbackDate;

    @JsonIgnore
    @OneToOne
    private User users;

    @JsonIgnore
    @OneToOne
    private Bus bus;
}
