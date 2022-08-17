package com.country_code.Country_code_identifier.Sevice;

import com.country_code.Country_code_identifier.Exception.NumberNotCorrectException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

public class NumberValidator {

    public static void validateNumber(String number,String countryCode, String countryName) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        String isoCode = phoneNumberUtil.getRegionCodeForCountryCode(Integer.parseInt(countryCode));
        int phoneLength=0;
        try {
            String exampleNumber = String.valueOf(phoneNumberUtil.getExampleNumber(isoCode).getNationalNumber());
            phoneLength = exampleNumber.length();
            number = number.substring(countryCode.length());
            if (number.length() != phoneLength) {
                throw new NumberNotCorrectException(countryName, countryCode, String.valueOf(phoneLength));
            }
        }catch (Exception e){
            if (e instanceof NumberNotCorrectException){throw new  NumberNotCorrectException(countryName, countryCode, String.valueOf(phoneLength));}
        }
    }
}
