package com.ironhack.labjavaintrotojpa.repositories;

import com.ironhack.labjavaintrotojpa.model.Aircraft;
import com.ironhack.labjavaintrotojpa.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;
    AircraftRepository aircraftRepository;

    @BeforeEach
    void setUp() {

        flightRepository.deleteAll();
        aircraftRepository.deleteAll();

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

    @Test
    void findByFlightNumber() {
        List<Flight> flights = flightRepository.findByFlightNumber("DL122");
        assertEquals(2, flights.size());
        assertEquals("DL122", flights.get(0).getFlightNumber());
        assertEquals("DL122", flights.get(1).getFlightNumber());

    }

    @Test
    void findByDistanceGreaterThan() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(2000);
        assertEquals(2, flights.size());
        assertEquals("DL122", flights.get(0).getFlightNumber());
        assertEquals("DL122", flights.get(1).getFlightNumber());
    }
}