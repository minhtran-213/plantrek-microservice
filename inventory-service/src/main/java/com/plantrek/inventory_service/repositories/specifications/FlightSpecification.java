package com.plantrek.inventory_service.repositories.specifications;

import com.plantrek.inventory_service.models.dtos.criterias.FlightsSearchCriteria;
import com.plantrek.inventory_service.models.entities.FlightEntity;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class FlightSpecification {

    public static Specification<FlightEntity> findFlightsByCriteria(FlightsSearchCriteria criteria) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (StringUtils.isNotEmpty(criteria.getOrigin())) {
                predicates.getExpressions().add(cb.equal(root.get("origin"), criteria.getOrigin()));
            }

            if (StringUtils.isNotEmpty(criteria.getDestination())) {
                predicates.getExpressions().add(cb.equal(root.get("destination"), criteria.getDestination()));
            }

            if (StringUtils.isNotEmpty(criteria.getAirline())) {
                predicates.getExpressions().add(cb.equal(root.get("airline"), criteria.getAirline()));
            }

            return predicates;
        };
    }
}
