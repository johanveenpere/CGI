package org.example.cgi.Model;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.sql.Date;

public interface FlightsRepository extends JpaRepository<Flight, Long> , JpaSpecificationExecutor<Flight> {
    static Specification<Flight> priceGreaterThanOrEqual(float minPrice) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("Flight").get("price"), minPrice));
    }

    static Specification<Flight> priceLessThanOrEqual(float maxPrice) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("Flight").get("price"), maxPrice));
    }

    static Specification<Flight> destination(String destination) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("Flight").get("price"), destination));
    }

    static Specification<Flight> arrivalTime(Date arrivalTime) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("Flight").get("price"), arrivalTime));
    }

}
