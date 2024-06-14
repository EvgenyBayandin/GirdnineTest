package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class DepartureAfterArrivalFilter implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .noneMatch(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }

}
