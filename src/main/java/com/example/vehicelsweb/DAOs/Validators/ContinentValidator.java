package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Continent;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContinentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Continent.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "continentname", "Empty continent name");

        Continent continent = (Continent) target;

        Pattern pattern = Pattern.compile("^\\b[A-z]+\\b( \\b[A-z]*\\b)?$");
        Matcher matcher = pattern.matcher(continent.getContinentname());

        if (!matcher.find()) {
            errors.rejectValue("continentname", "Invalid continent name");
        }
    }
}
