package com.cg.Service;

import com.cg.Model.Reservation;
import com.cg.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;   //for connect reservation repository

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }  //for fetch reservation list

    @Override
    public Reservation saveReservation(Reservation reservation) {

        return reservationRepository.save(reservation);

    }  // for save reservation details

    @Override
    public Reservation getReservationById(int reservationId) {
        Optional< Reservation > optional = reservationRepository.findById(reservationId);  // reservation details by id
        Reservation reservation = null;
        if (optional.isPresent()) {        //if reservation present then fetch details
            reservation = optional.get();
        } else {                            // if not then throw exception
            throw new RuntimeException(" User not found for id :: " + reservationId);
        }
        return reservation;   // return reservation
    }

    @Override
    public void deleteReservationById(int id) {
        this.reservationRepository.deleteById(id);
    }
}
