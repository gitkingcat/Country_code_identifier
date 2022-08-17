package com.country_code.Country_code_identifier.Exception;

public class CountryCodeException extends ApplicationException{

    public CountryCodeException() {
        super("Country code not found");
    }
}
