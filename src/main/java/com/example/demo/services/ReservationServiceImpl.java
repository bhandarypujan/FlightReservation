package com.example.demo.services;

import com.example.demo.dto.ReservationRequest;
import com.example.demo.entities.Passenger;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.flight;
import com.example.demo.repos.FlightRepository;
import com.example.demo.repos.PassengerRepository;
import com.example.demo.repos.ReservationRepository;
import com.example.demo.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.util.emailUtil;

@Service
public class ReservationServiceImpl implements ReservationService {
@Autowired
    FlightRepository flightRepository;
@Autowired
PassengerRepository passengerRepository;
@Autowired
ReservationRepository reservationRepository;
@Autowired
PdfGenerator pdfGenerator;

@Autowired
emailUtil emailUtil;



    @Override
    public Reservation bookFlight(ReservationRequest request) {



        Integer flightID= request.getFlightID();
        flight flight = flightRepository.findOne(flightID);

        Passenger passenger = new Passenger();
        passenger.setFirst_Name(request.getPassengerFirstName());
        passenger.setLast_Name(request.getPassengerLastName());
        passenger.setMiddle_Name(request.getPassengerMiddleName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setChecked_In(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        pdfGenerator.generateItinerary(savedReservation,
                "G:\\reservations\\reservation"
                        +savedReservation.getID()+".pdf");
        emailUtil.sendItinerary(passenger.getEmail(),"G:\\reservations\\reservation"+savedPassenger.getID()+".pdf");
        return  savedReservation;

    }
}
