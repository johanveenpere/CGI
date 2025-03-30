package org.example.cgi.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String destination;
    Date arrivaltime;
    Time flightlength;
    float price;
    @OneToMany
    List<Seat> flightSeats;
}
