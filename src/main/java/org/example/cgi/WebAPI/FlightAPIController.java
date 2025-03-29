package org.example.cgi.WebAPI;

import org.example.cgi.Model.Flight;
import org.example.cgi.Model.FlightsRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.cgi.Model.FlightsRepository.priceGreaterThanOrEqual;

@RestController
public class FlightAPIController {

    private final FlightsRepository repository;

    public FlightAPIController(FlightsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/flights")
    public List<Flight> flights(@RequestParam(value = "minprice", required = false) Float minprice,
                                @RequestParam(value = "maxprice", required = false) Float maxprice,
                                @RequestParam(value = "location", required = false) String location,
                                @RequestParam(value = "date", required = false) String date) {
        Specification<Flight> spec = Specification.where(null);
        if (minprice != null) {
            spec = spec.and(priceGreaterThanOrEqual(minprice));
        }
        if (maxprice != null) {
            spec = spec.and(priceLessThan(maxprice));
        }
        if (!location.isEmpty()) {
            spec = spec.and(destination(location));
        }
        if (!date.isEmpty()) {
            spec = spec.and(arrivalTime(date));
        }
        return repository.findAll(spec);
    }


}
