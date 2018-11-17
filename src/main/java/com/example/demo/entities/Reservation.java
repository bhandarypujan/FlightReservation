package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{

    private Boolean Checked_In;
    private int Number_Of_Bags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private flight flight;



    public Boolean getChecked_In() {
        return Checked_In;
    }

    public void setChecked_In(Boolean checked_In) {
        Checked_In = checked_In;
    }

    public int getNumber_Of_Bags() {
        return Number_Of_Bags;
    }

    public void setNumber_Of_Bags(int number_Of_Bags) {
        Number_Of_Bags = number_Of_Bags;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public com.example.demo.entities.flight getFlight() {
        return flight;
    }

    public void setFlight(com.example.demo.entities.flight flight) {
        this.flight = flight;
    }
}
