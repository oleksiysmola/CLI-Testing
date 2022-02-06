package com.bntaairport.flight;
import com.bntaairport.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FlightServiceTest {
        private FlightService underTest;

        @BeforeEach
        void setup(){
                // Initialize flight service class and variables to use for tests
                underTest = new FlightService();
                Flight flightTest1 = new Flight(
                        1,
                        LocalDateTime.of(2022, 12, 13, 14, 20),
                        FlightDestination.NORWAY,
                        100,
                        new Customer[100]);
                Flight flightTest2 = new Flight(
                        2,
                        LocalDateTime.of(2022, 12, 13, 12, 20),
                        FlightDestination.FRANCE,
                        105,
                        new Customer[105]);
                Flight flightTest3 = new Flight(
                        3,
                        LocalDateTime.of(2022, 11, 13, 14, 20),
                        FlightDestination.AUSTRALIA,
                        92,
                        new Customer[92]);
        }

        @Test
        void testBookFlight() {
                // Given

                // When

                // Then
        }
        @Test
        void testCountPassengers(){
                // Given

                // When

                // Then

        }
}