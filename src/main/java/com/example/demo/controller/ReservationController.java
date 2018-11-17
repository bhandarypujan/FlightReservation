package com.example.demo.controller;

import com.example.demo.dto.ReservationRequest;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.flight;
import com.example.demo.repos.FlightRepository;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightID") int flightID, ModelMap modelMap){
        flight flight = flightRepository.findOne(flightID);
        modelMap.addAttribute("flight",flight);
        return "completeReservation";
    }
    @RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request,ModelMap modelMap){
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Reservation Created Successfully and ID = "+reservation.getID());

        return "reservationConfirmation";

    }

}
