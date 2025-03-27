package org.example.cgi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seat {
    @Id
    private Long id;
    int rowNum;
    int columnNum;

}
