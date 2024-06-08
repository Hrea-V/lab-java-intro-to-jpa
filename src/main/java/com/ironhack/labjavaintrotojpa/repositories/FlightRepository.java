package com.ironhack.labjavaintrotojpa.repositories;

import com.ironhack.labjavaintrotojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    //Write tests to verify your ability to find flights by flight number.
    //Write tests to verify your ability to find flights with a distance greater than 500 miles.


    //Find flights by flight number
    List<Flight> findByFlightNumber(String flightNumber);

    //Find flights with a distance greater than 500 miles
    List<Flight> findByFlightMileageGreaterThan(Integer distance);

//    //JPQL Query Methods
//    //    Find flights by flight number
//    @Query("SELECT f FROM Flight f WHERE f.flightNumber = :flightNumber")
//    List<Flight> FindByFlightNumberJPQL(String flightNumber);
//    //    Find flights with a distance greater than 500 miles
//    @Query("SELECT f FROM Flight f WHERE f.flightMileage > :distance")
//    List<Flight> FindByDistanceGreaterThanJPQL(Integer distance);


}
