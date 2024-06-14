package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // All flights:
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("All flights: ");
        flights.forEach(System.out::println);

        // Flights after filtering out flights departing before current time:
        FlightFilter departureBeforeCurrentTimeFilter = new DepartureBeforeCurrentTimeFilter();
        System.out.println("\nFlights after filtering out flights departing before current time:");
        List<Flight> filteredFlights= departureBeforeCurrentTimeFilter.filterFlights(flights);
        filteredFlights.forEach(System.out::println);

    }
}
