package com.ironhack.labjavaintrotojpa.repositories;

import com.ironhack.labjavaintrotojpa.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {

    //Write tests to verify your ability to find aircraft with names containing "Boeing".


    //Find aircraft with names containing "Boeing"
    List<Aircraft> findByAircraftNameContaining(String aircraftName);



//    //JPQL Query Methods
//    //    Find aircraft with names containing "Boeing"
//    @Query("SELECT a FROM Aircraft a WHERE a.aircraftName LIKE %:name%")
//    List<Aircraft> findByNameContainingJPQL(String name);

}
