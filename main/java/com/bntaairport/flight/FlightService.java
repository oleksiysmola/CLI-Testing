package com.bntaairport.flight;

import com.bntaairport.airport.Airport;
import com.bntaairport.customer.Customer;

public class FlightService {

    public void bookFlight(Flight flight, Customer customer) {
        // check if the flight exists using the flight number? maybe we don't need to do this
        for (int i = 0; i<flight.getMaxCapacity(); i++){
            if (flight.getCustomersOnFlight()[i]==null || (flight.getCustomersOnFlight()[i].equals(customer))==false){
                System.out.println("Booking completed! These are the details: Flight number: " +
                        flight.getFlightNumber() + ", Departure time: " + flight.getDepartureTime()
                        + ", Destination: " + flight.getDestination());
                flight.getCustomersOnFlight()[i] = customer;
                break;
            }
        }
    }

    public void cancelFlight(Flight flight, Customer customer) {
        // check if the flight exists using the flight number? maybe we don't need to do this
        for (int i = 0; i<flight.getMaxCapacity(); i++){
            if (customer.equals(flight.getCustomersOnFlight()[i])){
                System.out.println("Your flight has been successfully cancelled! These are the details:" +
                        " Flight number: " + flight.getFlightNumber() + ", Departure time: " +
                        flight.getDepartureTime() + ", Destination: " + flight.getDestination());
                flight.getCustomersOnFlight()[i] = null;
                break;
            }
        }
    }

    public int countPassengers(Flight flight){
        // Obtain passengers
        Customer[] passengers = flight.getCustomersOnFlight();
        // Initialise counter
        int numPassengers = 0;
        // Loop over passengers
        for (int i = 0; i < passengers.length; i++){
            // If current seat is not empty update number of passengers
            if (passengers[i] != null){
                numPassengers += 1;
            } else {
                break;
            }
        }
        return numPassengers;
    }

    public void displayFlights(Airport airport){
        Flight[] flights = airport.getFlightsArray();
        int seatsLeft = 0;
        for (int i=0; i<flights.length; i++){
            seatsLeft = flights[i].getMaxCapacity() - countPassengers(flights[i]);
            System.out.println("Flight number: " + flights[i].getFlightNumber() +
                    ", Departure time: " + flights[i].getDepartureTime() + ", Destination: "
                    + flights[i].getDestination() + ", Seats remaining: " + seatsLeft);
        }
    }

    public Flight findFlightByNum(String flightNum, Airport airport){
        Flight[] flights = airport.getFlightsArray();
        for(int i=0; i<flights.length; i++){
            if (flights[i].getFlightNumber() == Integer.parseInt(flightNum)){
                return flights[i];
            }
        }
        return null;
    }

    public void viewBookings(Airport airport, Customer customer) {
        Flight[] flights = airport.getFlightsArray();
        boolean hasFlights = false;
        for (int i = 0; i < flights.length; i++) {
            Customer[] customers = flights[i].getCustomersOnFlight();
            for (int j = 0; j < customers.length; j++) {
                if (customers[j] == customer) {
                    System.out.println("Fetching Flight Information...");
                    System.out.println("Flight number: " + flights[i].getFlightNumber() +
                            ", Departure time: " + flights[i].getDepartureTime() + ", Destination: "
                            + flights[i].getDestination());
                    hasFlights = true;
                }
            }

        }
        if (hasFlights == false) {
            System.out.println("Sorry, you have no flights booked!");
        }

    }
}