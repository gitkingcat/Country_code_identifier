package com.country_code.Country_code_identifier.Exception;

public class NumberNotCorrectException extends ApplicationException{
    public NumberNotCorrectException(String countryName,String countryCode, String phoneLength) {
        super("Number for "+countryName+"(+"+countryCode+") should be "+phoneLength+" characters long.");
    }
}
