package com.bntaairport.flight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FlightDAO {
    private File file;

    public FlightDAO(){
        this.file = new File("flights.csv");
    }

    public void toFile(Flight[] flights) {

        try {
            if (!file.exists()) { //if this file doesn't already exist, create it using .createNewFile()
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String line = "";
            for (int i = 0; i < flights.length; i++) {
                // Print properties
                line += flights[i].getFlightNumber() + ",";
                line += flights[i].getDepartureTime() + ",";
                line += flights[i].getDestination() + ",";
                line += flights[i].getMaxCapacity() + ",";
                line += flights[i].getCustomersOnFlight() + ",";

                printWriter.println(line.substring(0, line.length() - 1));
            }
            // Finish writing
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Flight[] readFile(){
        try {
            // Initialise scanner for file
            Scanner scanner = new Scanner(file);
            // Initialise line counter
            int numLines = 0;
            while (scanner.hasNext()){
                // Update line count and move to next line
                numLines++;
                scanner.nextLine();
            }
            // Initialise flight array
            Flight[] flights = new Flight[numLines];
            // Reset scanner
            scanner = new Scanner(file);
            String line = ""; // Initialise empty string for line
            String[] properties = new String[5]; // Split line into array of properties
            // Loop again through file
            while (scanner.hasNext()){
                // Convert line to string
                line = scanner.nextLine();
                // Line
                line.split(",");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}