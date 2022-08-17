package com.country_code.Country_code_identifier.Sevice;

import com.country_code.Country_code_identifier.Exception.CountryCodeException;
import com.country_code.Country_code_identifier.Repository.CountryCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCodeServiceImpl implements CountryCodeService {


    @Override
    public String getCountry(String s) throws CountryCodeException {
        s = cleanNumber(s);
        int maxNumber = s.toCharArray().length;
        if (maxNumber>6){maxNumber=6;}
        String request = "";
        String result = "";
        String countryCode="";
        for (int i = 0; i<maxNumber; i++){
            request+=s.toCharArray()[i];
            String resultTmp = CountryCodeRepo.hashMap.get(request);
            if (resultTmp!=null){
                result=resultTmp;
                countryCode=request;
            }
        }
        if (result.isEmpty()){
            throw new CountryCodeException();
        }
        NumberValidator.validateNumber(s,countryCode,result);
        return result;
    }

    private String cleanNumber(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "");
        return s;
    }
}
