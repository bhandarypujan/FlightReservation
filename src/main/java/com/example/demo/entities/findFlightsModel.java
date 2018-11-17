package com.example.demo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class findFlightsModel {
    private String from;
    private String to;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
