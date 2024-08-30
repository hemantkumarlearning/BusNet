package com.hemant.controller;

import com.hemant.dto.ReservationDTO;
import com.hemant.exceptions.ReservationException;
import com.hemant.model.Reservation;
import com.hemant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDTO reservationDTO) throws ReservationException {
        Reservation reservation = reservationService.addReservation(reservationDTO);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }
}
