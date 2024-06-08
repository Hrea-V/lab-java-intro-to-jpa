package com.ironhack.labjavaintrotojpa.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "flights")
public class Flight {

    //Create a class called Flight with the following variables:
    //
    //    flightId (integer): an auto-generated unique identifier, private member
    //    flightNumber (string): a unique identifier, private member
    //    aircraft (string): private member
    //    totalAircraftSeats (integer): private member
    //    flightMileage (integer): private member
    //    Add an empty constructor to the Flight class for Hibernate to create new instances of the class.
    //    Add a parameterized constructor to the Flight class that takes flightNumber, aircraft, totalAircraftSeats and flightMileage as parameters.
    //    Add public getter and setter methods for each variable in the Flight class.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private String flightNumber;
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;
    private Integer flightMileage;

    public Flight(String flightNumber, Aircraft aircraft, Integer flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.flightMileage = flightMileage;
    }

    public Flight() {
    }

}
