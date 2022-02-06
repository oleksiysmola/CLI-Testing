package com.bntaairport.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportNumberValidation {
    public boolean validatePassportNumber(String passportNumber){
        // boolean result = email.equals("[a-z]+[\\.]*[a-z]*[0-9]*[\\@][a-z]*[\\.]com");

        // Establishes pattern to match
        Pattern pattern = Pattern.compile("\\d{9,13}");
        // Set matcher
        Matcher matcher = pattern.matcher(passportNumber);
        // Checks for match and return
        boolean result = matcher.matches();

        return result;
    }
}
