package com.cg.Service;

import com.cg.Model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    List<Reservation> getAllReservations();   // for fetch all reservations
    Reservation saveReservation(Reservation reservation);   // for add reservation
    Reservation getReservationById(int reservationId);  // get reservation data by id
    void deleteReservationById(int id);


}
