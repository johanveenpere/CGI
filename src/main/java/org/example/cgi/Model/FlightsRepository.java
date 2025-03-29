package org.example.cgi.Model;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlightsRepository extends JpaRepository<Flight, Long> , JpaSpecificationExecutor<Flight> {
    static Specification<Flight> priceGreaterThanOrEqual(float minPrice) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(Flight_.price), minPrice));

    }

    static Specification<Flight> priceLessThanOrEqual(float maxPrice) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get(Flight_.price), maxPrice));
    }

}
