package com.bntaairport.regex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidationTest {
    private EmailValidation underTest;

    @Test
    void returnsTrueWhenEmailIsValid(){
        // Given
        String testEmail = "real1@gmail.com";
        // When
        boolean actual = underTest.validateEmail(testEmail);
        // Then
        boolean expected = true;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void returnsFalseWhenEmailIsInvalid(){
        // Given
        String testEmail = "real1gmail.com";
        // When
        boolean actual = underTest.validateEmail(testEmail);
        // Then
        boolean expected = false;
        assertThat(actual).isEqualTo(expected);
    }
    @BeforeEach
    void setUp(){
        this.underTest = new EmailValidation();
    }
}
