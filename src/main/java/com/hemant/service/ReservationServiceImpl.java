package com.hemant.service;

import com.hemant.dto.ReservationDTO;
import com.hemant.exceptions.ReservationException;
import com.hemant.model.Bus;
import com.hemant.model.Reservation;
import com.hemant.model.User;
import com.hemant.repository.BusRepo;
import com.hemant.repository.ReservationRepo;
import com.hemant.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Reservation addReservation(ReservationDTO reservationDTO) throws ReservationException{
        User user = userRepo.findByEmail(reservationDTO.getUserDTO().getEmail());

        Optional<Bus> bus=busRepo.findById(reservationDTO.getBusDTO().getBusId());

        if (bus.isEmpty()){
            throw new ReservationException("Bus not found for id " + reservationDTO.getBusDTO().getBusId());
        }
        if(reservationDTO.getJourneyDate().isBefore(LocalDate.now())){
            throw new ReservationException("Please enter future date!");
        }
        if(!reservationDTO.getDestination().equalsIgnoreCase(bus.get().getRouteTo())){
            throw new ReservationException("Bus is not Available on route :" +reservationDTO.getDestination());
        }
        int seat=bus.get().getAvailableSeats();
        if(seat<reservationDTO.getNoOfSeatsToBook()){
            throw new ReservationException("Seat is not available");

        }
        bus.get().setAvailableSeats(seat-reservationDTO.getNoOfSeatsToBook());
        Bus upadateBus=busRepo.save(bus.get());

        Reservation reservation = new Reservation();

        reservation.setReservationStatus("Successfull");
        reservation.setDestination(reservationDTO.getDestination());
        reservation.setReservationDate(LocalDate.now());
        reservation.setReservationTime(LocalTime.now());
        reservation.setNoOfSeatsBooked(reservationDTO.getNoOfSeatsToBook());
        reservation.setFare((bus.get().getFarePerSeat())*(reservationDTO.getNoOfSeatsToBook()));
        reservation.setJourneyDate(reservationDTO.getJourneyDate());
        reservation.setUser(user);
        reservation.setBus(upadateBus);
        reservation.setReservationType("General");
        reservation.setSource(reservationDTO.getSource());
        return reservationRepo.save(reservation);

    }

    @Override
    public Reservation updateReservation(Reservation reservation) throws ReservationException {
        Optional<Reservation> opt=reservationRepo.findById(reservation.getReservationId());

        if(opt.isPresent()) {
            Reservation updateReservation=reservationRepo.save(reservation);


            return updateReservation;
        }
        else {
            throw new ReservationException("Insert correct Reservation Id");
        }
    }

    @Override
    public Reservation deleteReservation(Integer reservationId) throws ReservationException{
        return null;
    }

    @Override
    public Reservation viewAllReservation(Integer reservationId) throws ReservationException{
        return null;
    }

    @Override
    public List<Reservation> getReservationDeatials(String key) throws ReservationException{
        return List.of();
    }
}
