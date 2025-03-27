package org.example.cgi.WebAPI;

import org.example.cgi.Model.Flight;
import org.example.cgi.Model.FlightsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FlightAPIController {

    private final FlightsRepository repository;

    public FlightAPIController(FlightsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/flights")
    public List<Flight> flights(@RequestParam(value = "minprice", required = false) Integer minprice,
                                @RequestParam(value = "maxprice", required = false) Integer maxprice,
                                @RequestParam(value = "location", required = false) String location,
                                @RequestParam(value = "date", required = false) String date) {
        return repository.findAll();
    }

}
