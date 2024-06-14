package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // All flights:
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("All flights: ");
        flights.forEach(System.out::println);
        
    }
}
