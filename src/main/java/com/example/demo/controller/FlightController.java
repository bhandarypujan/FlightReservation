package com.example.demo.controller;

import com.example.demo.entities.findFlightsModel;
import com.example.demo.entities.flight;
import com.example.demo.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightRepository flightRepository;


    @RequestMapping("findFlights")
    public String findFlights(@ModelAttribute("fltatr") findFlightsModel flightModel, ModelMap modelMap){
        List<flight> flights = flightRepository.findFlights(flightModel.getFrom(), flightModel.getTo(), flightModel.getDepartureDate());
        modelMap.addAttribute("flights",flights);
        return "displayFlights";
    }


   @RequestMapping("admin/showAddFlight")
    private String showAddFlight(){

        return "addFlight";
   }


}