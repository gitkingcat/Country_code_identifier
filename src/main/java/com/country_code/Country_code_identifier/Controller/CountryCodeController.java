package com.country_code.Country_code_identifier.Controller;

import com.country_code.Country_code_identifier.Exception.ApplicationException;
import com.country_code.Country_code_identifier.Sevice.CountryCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryCodeController {

    @Autowired
    private CountryCodeService countryCodeService;

    @GetMapping(value = "/main")
    public String getForm(){
        return "main";
    }

    @PostMapping(value = "/checknumber")
    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public String checkNumber(@RequestParam String number) {
        try {
            return countryCodeService.getCountry(number);
        } catch (ApplicationException e) {
            return e.getMessage();
        }
    }


}
