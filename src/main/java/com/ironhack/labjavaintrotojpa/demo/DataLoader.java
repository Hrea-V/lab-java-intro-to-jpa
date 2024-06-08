package com.ironhack.labjavaintrotojpa.demo;

import com.ironhack.labjavaintrotojpa.enums.CustomerStatus;
import com.ironhack.labjavaintrotojpa.model.Aircraft;
import com.ironhack.labjavaintrotojpa.model.Customer;
import com.ironhack.labjavaintrotojpa.model.Flight;
import com.ironhack.labjavaintrotojpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;
    private CustomerRepository customerRepository;
    private AircraftRepository aircraftRepository;


    @Override
    public void run(String... args) throws Exception {

        Customer customer1 = new Customer("Augustine Riviera", CustomerStatus.GOLD, 115235);
        Customer customer2 = new Customer("Alaina Sepulvida", CustomerStatus.NONE, 6008);
        Customer customer3 = new Customer("Tom Jones", CustomerStatus.GOLD, 205767);
        Customer customer4 = new Customer("Sam Rio", CustomerStatus.NONE, 2653);
        Customer customer5 = new Customer("Jessica James", CustomerStatus.SILVER, 127656);
        Customer customer6 = new Customer("Ana Janco", CustomerStatus.SILVER, 136773);
        Customer customer7 = new Customer("Jennifer Cortez", CustomerStatus.GOLD, 300582);
        Customer customer8 = new Customer("Christian Janco", CustomerStatus.SILVER, 14642);
        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8));

        Aircraft aircraft1 = new Aircraft("Boeing 747", 400);
        Aircraft aircraft2 = new Aircraft("Airbus A330", 236);
        Aircraft aircraft3 = new Aircraft("Boeing 777", 264);
        aircraftRepository.saveAll(List.of(aircraft1, aircraft2, aircraft3));


        Flight flight1 = new Flight("DL122", aircraft1, 135);
        Flight flight2 = new Flight("DL122", aircraft2, 4370);
        Flight flight3 = new Flight("DL53", aircraft3, 2078);
        Flight flight4 = new Flight("DL222", aircraft3, 1765);
        Flight flight5 = new Flight("DL37", aircraft1, 531);
        flightRepository.saveAll(List.of(flight1, flight2, flight3, flight4, flight5));



    }
}
