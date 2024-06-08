package com.ironhack.labjavaintrotojpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class FlightBooking {

    //Create a class called FlightBooking with the following variables:
    //
    //    bookingId (integer): an auto-generated unique identifier, private member
    //    customerId (integer): private member
    //    flightId (integer): private member
    //    Add an empty constructor to the FlightBooking class for Hibernate to create new instances of the class.
    //    Add a parameterized constructor to the FlightBooking class that takes customerId and flightId as parameters.
    //    Add public getter and setter methods for each variable in the FlightBooking class.
    //    Add foreign key constraints in the FlightBooking class to reference the customerId and flightId in the customers and flights tables respectively.


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private Integer customerId;
    private Integer flightId;

    public FlightBooking(Integer customerId, Integer flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public FlightBooking() {
    }


}
