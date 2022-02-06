package com.bntaairport.flight;

import com.bntaairport.customer.Customer;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Flight {
    private int flightNumber;
    private LocalDateTime departureTime;
    private FlightDestination destination;    //THIS IS AN ENUM
    private int maxCapacity;
    private Customer[] customersOnFlight;

    public Flight(int flightNumber, LocalDateTime departureTime, FlightDestination destination, int maxCapacity, Customer[] customersOnFlight) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.destination = destination;
        this.maxCapacity = maxCapacity;
        this.customersOnFlight = customersOnFlight;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public FlightDestination getDestination() {
        return destination;
    }

    public void setDestination(FlightDestination destination) {
        this.destination = destination;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Customer[] getCustomersOnFlight() {
        return customersOnFlight;
    }

    public void setCustomersOnFlight(Customer[] customersOnFlight) {
        this.customersOnFlight = customersOnFlight;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", departureTime=" + departureTime +
                ", destination=" + destination +
                ", maxCapacity=" + maxCapacity +
                ", customersOnFlight=" + Arrays.toString(customersOnFlight) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber && maxCapacity == flight.maxCapacity && Objects.equals(departureTime, flight.departureTime) && destination == flight.destination && Arrays.equals(customersOnFlight, flight.customersOnFlight);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(flightNumber, departureTime, destination, maxCapacity);
        result = 31 * result + Arrays.hashCode(customersOnFlight);
        return result;
    }
}
