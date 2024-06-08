package com.ironhack.labjavaintrotojpa.model;

import com.ironhack.labjavaintrotojpa.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    //Create a class called Customer with the following variables:
    //
    //    customerId (integer): an auto-generated unique identifier, private member
    //    customerName (string): private member
    //    customerStatus (string): representing an enum, private member
    //    totalCustomerMileage (integer): private member
    //    Add an empty constructor to the Customer class for Hibernate to create new instances of the class.
    //    Add a parameterized constructor to the Customer class that takes customerName, customerStatus and totalCustomerMileage as parameters.
    //    Add public getter and setter methods for each variable in the Customer class.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
    private Integer totalCustomerMileage;


    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public Customer() {
    }

}
