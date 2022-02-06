package com.bntaairport.flight;

import com.bntaairport.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class FlightDAOTest {
    private FlightDAO underTest;
    private Flight[] testFlights;

    @BeforeEach
    void setup(){
        underTest = new FlightDAO();
        // Generate set of flights to test
        Flight flight1 = new Flight(1, LocalDateTime.of(2022,03,10,1,15), FlightDestination.SPAIN, 5, new Customer[5]);
        Flight flight2 = new Flight(2, LocalDateTime.of(2022,04,12,2,15), FlightDestination.AUSTRALIA, 6, new Customer[6]);
        Flight flight3 = new Flight(3, LocalDateTime.of(2022,05,13,3,15), FlightDestination.FRANCE, 3, new Customer[3]);
        Flight flight4 = new Flight(4, LocalDateTime.of(2022,06,14,4,15), FlightDestination.IRELAND, 7, new Customer[7]);
        Flight flight5 = new Flight(5, LocalDateTime.of(2022,07,15,6,15), FlightDestination.NORWAY, 4, new Customer[4]);
        testFlights = new Flight[]{
                flight1,
                flight2,
                flight3,
                flight4,
                flight5
        };
    }
    @Test
    void testToCSV(){
        // Given
        Flight[] flights = testFlights;

        // When
        underTest.toFile(flights);

        // Then
    }
}
