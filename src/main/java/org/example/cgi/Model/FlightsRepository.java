package org.example.cgi.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<Flight, Long> {
}
