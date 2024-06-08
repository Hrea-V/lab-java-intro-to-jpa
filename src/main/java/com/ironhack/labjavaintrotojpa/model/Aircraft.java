package com.ironhack.labjavaintrotojpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aircraftId;
    private String aircraftName;
    private Integer totalSeats;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL)
    private List<Flight> flights;


    public Aircraft(String aircraftName, Integer totalSeats) {
        this.aircraftName = aircraftName;
        this.totalSeats = totalSeats;
    }
}
