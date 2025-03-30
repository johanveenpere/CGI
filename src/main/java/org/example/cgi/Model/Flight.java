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
    String origin;
    String destination;
    Date arrivaltime;
    Time flightlength;
    float price;
    @OneToMany
    List<Seat> flightSeats;
    public Long getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getArrivaltime() {
        return arrivaltime;
    }

    public Time getFlightlength() {
        return flightlength;
    }

    public float getPrice() {
        return price;
    }

    public List<Seat> getFlightSeats() {
        return flightSeats;
    }
}
