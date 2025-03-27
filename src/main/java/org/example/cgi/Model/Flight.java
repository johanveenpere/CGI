package org.example.cgi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
public class Flight {
    @Id
    private Long id;
    String destination;
    Date arrivalTime;
    Time flightLength;
    float price;
    @OneToMany
    List<Seat> flightSeats;
}
