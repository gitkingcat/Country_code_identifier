package com.country_code.Country_code_identifier.Sevice;

import com.country_code.Country_code_identifier.Exception.CountryCodeException;

import java.util.List;

public interface CountryCodeService {
    String getCountry(String s) throws CountryCodeException;
}
