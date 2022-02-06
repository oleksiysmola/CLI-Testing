package com.bntaairport.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCustomerDAO {
    private CustomerDAO underTest;
    private Customer[] customers;
    private Customer newCustomer;

    @BeforeEach
    void setUp(){
        this.underTest = new CustomerDAO();
        Customer customer1 = new Customer(
                1,
                "Phil",
                "pswift@yandex.ru",
                "007839432",
                "02934568");
        Customer customer2 = new Customer(
                2,
                "Lampart",
                "lampart@gmail.com",
                "0078393842",
                "02934268");
        this.customers = new Customer[]{customer1, customer2};
        this.newCustomer = new Customer(
                3,
                "Dave",
                "dave@gmail.com",
                "007342463",
                "384953847");
    }

    @Test
    @Order(1)
    void canStoreInFile(){
        // Given
        Customer[] testCustomers = customers;
        File testFile = underTest.getFile();

        // When
        underTest.createFile(testCustomers);

        // Then
        String[] expected = new String[]{
                "1,Phil,pswift@yandex.ru,007839432,02934568",
                "2,Lampart,lampart@gmail.com,0078393842,02934268"};
        String[] actual = new String[2];
        try {
            // If the to file method is invoked the file must exist
            assertThat(testFile.exists()).isEqualTo(true);
            // Scanner to check the content matches what we expect
            Scanner testScanner = new Scanner(testFile);
            int lineNumber = 0;
            // Loop over file
            while (testScanner.hasNext()){
                actual[lineNumber] = testScanner.nextLine();
                lineNumber++;
            }
            // Check the expected String array matches the actual result
            assertThat(actual).isEqualTo(expected);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    @Order(2)
    void canReadFile(){
        // Given
        File testFile = underTest.getFile();

        // When
        Customer[] actualCustomers = underTest.readFile();

        // Then
        Customer[] expected = customers;
        for (int i = 0; i < expected.length; i++){
            assertThat(actualCustomers[i].equals(expected[i])).isTrue();
        }
    }
    @Test
    @Order(3)
    void canAddToFile(){
        // Given
        Customer[] testCustomer = new Customer[]{newCustomer};
        File testFile = underTest.getFile();

        // When
        underTest.toFile(testCustomer);

        // Then
        String[] expected = new String[]{
                "1,Phil,pswift@yandex.ru,007839432,02934568",
                "2,Lampart,lampart@gmail.com,0078393842,02934268",
                "3,Dave,dave@gmail.com,007342463,384953847"};
        String[] actual = new String[3];
        try {
            // If the to file method is invoked the file must exist
            assertThat(testFile.exists()).isEqualTo(true);
            // Scanner to check the content matches what we expect
            Scanner testScanner = new Scanner(testFile);
            int lineNumber = 0;
            // Loop over file
            while (testScanner.hasNext()){
                actual[lineNumber] = testScanner.nextLine();
                lineNumber++;
            }
            // Check the expected String array matches the actual result
            assertThat(actual).isEqualTo(expected);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
