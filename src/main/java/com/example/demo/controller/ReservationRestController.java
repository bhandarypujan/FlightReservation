package com.example.demo.controller;

import com.example.demo.dto.ReservationUpdateRequest;
import com.example.demo.entities.Reservation;
import com.example.demo.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationRestController {
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id")  Integer id){
       Reservation reservation = reservationRepository.findOne(id);
       return  reservation;

    }

    @RequestMapping("/reservations")
    public  Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation reservation = reservationRepository.findOne(request.getID());
        reservation.setChecked_In(request.getChecked_In());
        reservation.setNumber_Of_Bags(request.getNumber_Of_Bags());
        reservationRepository.save(reservation);
        return reservation;


    }
}
