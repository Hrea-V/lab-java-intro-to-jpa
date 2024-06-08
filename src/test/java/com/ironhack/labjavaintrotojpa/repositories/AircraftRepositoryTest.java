package com.ironhack.labjavaintrotojpa.repositories;

import com.ironhack.labjavaintrotojpa.model.Aircraft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AircraftRepositoryTest {

    @Autowired
    AircraftRepository aircraftRepository;


    @BeforeEach
    void setUp() {
        aircraftRepository.deleteAll();
        Aircraft aircraft1 = new Aircraft("Boeing 747", 400);
        Aircraft aircraft2 = new Aircraft("Airbus A330", 236);
        Aircraft aircraft3 = new Aircraft("Boeing 777", 264);
        aircraftRepository.saveAll(List.of(aircraft1, aircraft2, aircraft3));
    }
    @Test
    void findByNameContaining() {
        List<Aircraft> aircrafts = aircraftRepository.findByAircraftNameContaining("Boeing");
        assertEquals(2, aircrafts.size());
        assertEquals("Boeing 747", aircrafts.get(0).getAircraftName());
        assertEquals("Boeing 777", aircrafts.get(1).getAircraftName());
    }
}