package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Fueltype;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FueltypeValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Fueltype.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Fueltype fueltype = (Fueltype) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fueltypename", "emptyFueltypename");

        Pattern pattern = Pattern.compile("^\\b[A-z]+\\b( \\b[A-z]*\\b)?$");
        Matcher matcher = pattern.matcher(fueltype.getFueltypename());

        if (!matcher.matches()) {
            errors.rejectValue("fueltypename", "invalidFueltypename");
        }
    }
}
