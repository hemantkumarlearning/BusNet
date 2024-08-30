package com.hemant.service;

import com.hemant.dto.ReservationDTO;
import com.hemant.exceptions.ReservationException;
import com.hemant.model.Reservation;

import java.util.List;

public interface ReservationService {

    public Reservation addReservation(ReservationDTO reservationDTO) throws ReservationException;

    public Reservation updateReservation(Reservation reservation) throws ReservationException;

    public Reservation deleteReservation(Integer reservationId) throws ReservationException;

    public Reservation viewAllReservation(Integer reservationId) throws ReservationException;

    public List<Reservation> getReservationDeatials(String key) throws ReservationException;


}
