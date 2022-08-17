package com.country_code.Country_code_identifier.Sevice;

import com.country_code.Country_code_identifier.Exception.NumberNotCorrectException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @Test()
    void name() {

        Exception exception = assertThrows(NumberNotCorrectException.class, () -> {
            NumberValidator.validateNumber("37128282","371","Latvia");
        });

        String expectedMessage = "Number for "+"Latvia"+"(+"+"371"+") should be "+8+" characters long.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}