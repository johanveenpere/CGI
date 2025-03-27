package org.example.cgi.Seat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seat {
    @Id
    private Long id;
    int row;
    int column;
    
}
