package com.country_code.Country_code_identifier.Sevice;

import com.country_code.Country_code_identifier.Repository.CountryCodeRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
class CountryCodeServiceImplTest {


    @Test
    void getCountry() {
        CountryCodeRepo.initialize();
        CountryCodeService countryCodeService = new CountryCodeServiceImpl();
        assertTrue( countryCodeService.getCountry("+37128282828").contains("Latvia"));
        assertTrue( countryCodeService.getCountry("+37332828282").contains("Moldova"));
        assertTrue( countryCodeService.getCountry("+2632828288").contains("Zimbabwe"));
        assertTrue( countryCodeService.getCountry("+15750282828").contains("United States"));

    }
}