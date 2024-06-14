package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LongGroundTimeFilter implements FlightFilter {
    private static final long MAX_GROUND_TIME_MILLIS = Duration.ofHours(2).toMillis();

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(this::hasGroundTimeLessThanTwoHoursAndMultipleSegments)
                .collect(Collectors.toList());
    }

    private boolean hasGroundTimeLessThanTwoHoursAndMultipleSegments(Flight flight) {
        List<Segment> segments = flight.getSegments();
        // Исключаем перелеты с одним сегментом
        if (segments.size() <= 1) {
            return false;
        }

        // Возвращаем перелеты с временем нахождения на земле между сегментами не более двух часов
        for (int i = 0; i < segments.size() - 1; i++) {
            Segment currentSegment = segments.get(i);
            Segment nextSegment = segments.get(i + 1);
            Duration groundTime = Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate());
            if (groundTime.toMillis() > MAX_GROUND_TIME_MILLIS) {
                return false;
            }
        }

        return true;
    }

}