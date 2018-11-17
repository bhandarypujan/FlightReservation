package com.example.demo.services;

import com.example.demo.dto.ReservationRequest;
import com.example.demo.entities.Reservation;

public interface ReservationService   {

    public Reservation bookFlight(ReservationRequest request);


}
