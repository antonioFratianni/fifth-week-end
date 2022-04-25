package com.example.backend.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "show")

public class Show {
    @Id
    private String id;

    private Customer[] reservations;
    private int reservationNumber;
    private ArrayList<Customer> waitList;

    public Show() {
        this.reservations = new Customer[reservationNumber];
        this.waitList = new ArrayList<Customer>();
    }

    public Show(int n) {
        this.reservationNumber = n;
        this.reservations = new Customer[n];
        this.waitList = new ArrayList<Customer>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer[] getReservations() {
        return reservations;
    }

    public void setReservations(Customer[] reservations) {
        this.reservations = reservations;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public ArrayList<Customer> getWaitList() {
        return waitList;
    }

    public void setWaitList(ArrayList<Customer> waitList) {
        this.waitList = waitList;
    }
}
