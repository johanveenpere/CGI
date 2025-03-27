package org.example.cgi.Flight;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.example.cgi.Seat.Seat;

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
