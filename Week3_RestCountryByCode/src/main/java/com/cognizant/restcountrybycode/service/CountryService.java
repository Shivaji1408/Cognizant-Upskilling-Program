package com.cognizant.restcountrybycode.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.restcountrybycode.Country;

@Service
public class CountryService {

    public Country getCountry(String code) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                context.getBean("india", Country.class);

        if(country.getCode().equalsIgnoreCase(code)) {
            return country;
        }

        return null;
    }
}