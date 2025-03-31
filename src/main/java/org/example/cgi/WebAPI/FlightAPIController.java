package org.example.cgi.WebAPI;

import org.example.cgi.Model.Flight;
import org.example.cgi.Model.FlightsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

import static org.example.cgi.Model.FlightsRepository.*;

@RestController
public class FlightAPIController {

    private final FlightsRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(FlightAPIController.class);

    public FlightAPIController(FlightsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/flights")
    public List<Flight> flights(@RequestParam(value = "minprice", required = false) Float minprice,
                                @RequestParam(value = "maxprice", required = false) Float maxprice,
                                @RequestParam(value = "location", required = false) String location,
                                @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "ddMMyyyy") Date date) {
        Specification<Flight> spec = Specification.where(null);
        if (minprice != null) {
            spec = spec.and(priceGreaterThanOrEqual(minprice));
        }
        if (maxprice != null) {
            spec = spec.and(priceLessThanOrEqual(maxprice));
        }
        if (location!= null) {
            spec = spec.and(destination(location));
        }
        if (date != null) {
            spec = spec.and(arrivalTime(date));
        }
        List<Flight> result = repository.findAll();
        logger.info("query result {}", result);
        return result;
    }


}
