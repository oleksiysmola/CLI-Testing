package com.bntaairport.customer;

import java.io.*;
import java.util.Scanner;

public class CustomerDAO {
    private final File file;

    public CustomerDAO(){
        // Generate file of given path
        this.file = new File("customer.csv");
    }

    public File getFile(){
        return file;
    }

    public void createFile(Customer[] customers){
        try {
            // Check if file exists
            if (!file.exists()){
                file.createNewFile();
            }
            // Set up file and print writer
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            // Initialise line to be printed
            String line = "";
            // Loop over array
            for (int i = 0; i < customers.length; i++) {
                line = "";
                line += customers[i].getId() + ",";
                line += customers[i].getName() + ",";
                line += customers[i].getEmail() + ",";
                line += customers[i].getNumber() + ",";
                line += customers[i].getPassportNumber() + ",";
                // Print lines
                printWriter.println(line.substring(0, line.length() - 1));
            }
            // Finish writing
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toFile(Customer[] customers){
        try {
            // Check if file exists
            if (!file.exists()){
                file.createNewFile();
            }
            // Set up file and print writer
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            // Initialise line to be printed
            String line = "";
            // Loop over array
            for (int i = 0; i < customers.length; i++) {
                line = "";
                line += customers[i].getId() + ",";
                line += customers[i].getName() + ",";
                line += customers[i].getEmail() + ",";
                line += customers[i].getNumber() + ",";
                line += customers[i].getPassportNumber() + ",";
                // Print lines
                printWriter.println(line.substring(0, line.length() - 1));
            }
            // Finish writing
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Customer[] readFile(){
        try {
            // Initialise scanner
            Scanner scanner = new Scanner(file);
            // Counter for number of lines
            int numLines = 0;
            // Loop through doc while there is another line
            while (scanner.hasNext()){
                numLines++; // Update number of lines
                scanner.nextLine();
            }
            // Reset scanner
            scanner = new Scanner(file);
            // Initialise customer array
            Customer[] customers = new Customer[numLines];
            // Initialise strings for line and split properties
            String line = "";
            String[] properties = new String[5];
            // Loop through again this time returning to customer array
            for (int i = 0; i < customers.length; i++){
                // Read and split line by commas
                line = scanner.nextLine();
                properties = line.split(",");
                // Fill properties
                customers[i] = new Customer(
                        Long.parseLong(properties[0]),
                        properties[1],
                        properties[2],
                        properties[3],
                        properties[4]);
            }

            return customers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error customer data not found");
            return null;
        }
    }
}
