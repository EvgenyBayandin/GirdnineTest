import com.gridnine.testing.DepartureAfterArrivalFilter;
import com.gridnine.testing.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.LongGroundTimeFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterTest {
    private List<Flight> flights;
    private DepartureBeforeCurrentTimeFilter departureBeforeCurrentTimeFilter;
    private DepartureAfterArrivalFilter departureAfterArrivalFilter;
    private LongGroundTimeFilter longGroundTimeFilter;

    @BeforeEach
    void setUp() {
        flights = FlightBuilder.createFlights();
        departureBeforeCurrentTimeFilter = new DepartureBeforeCurrentTimeFilter();
        departureAfterArrivalFilter = new DepartureAfterArrivalFilter();
        longGroundTimeFilter = new LongGroundTimeFilter();
    }

    @Test
    void testDepartureBeforeCurrentTimeFilter() {
        List<Flight> filteredFlights = departureBeforeCurrentTimeFilter.filterFlights(flights);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    void testDepartureAfterArrivalFilter() {
        List<Flight> filteredFlights = departureAfterArrivalFilter.filterFlights(flights);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    void testLongGroundTimeFilter() {
        List<Flight> filteredFlights = longGroundTimeFilter.filterFlights(flights);
        assertEquals(2, filteredFlights.size());
    }
}