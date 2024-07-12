package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Country;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CountryValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Country.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Country country = (Country) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryname", "nameEmpty");

        Pattern pattern = Pattern.compile("^\\b[A-z]+\\b( \\b[A-z]+\\b)*$");
        Matcher matcher = pattern.matcher(country.getCountryname());

        if (!matcher.matches()) {
            errors.rejectValue("countryname", "countrynameInvalid");
        }
    }
}
