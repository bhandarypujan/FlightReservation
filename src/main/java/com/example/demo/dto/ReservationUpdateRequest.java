package com.example.demo.dto;

public class ReservationUpdateRequest {
    private Boolean Checked_In;
    private Integer ID;
    private int Number_Of_Bags;

    public Boolean getChecked_In() {
        return Checked_In;
    }

    public void setChecked_In(Boolean checked_In) {
        Checked_In = checked_In;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public int getNumber_Of_Bags() {
        return Number_Of_Bags;
    }

    public void setNumber_Of_Bags(int number_Of_Bags) {
        Number_Of_Bags = number_Of_Bags;
    }
}
