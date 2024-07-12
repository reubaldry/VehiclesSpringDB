package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Make;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MakeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Make.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Make make = (Make) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "makename", "emptyMakename");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "networth", "emptyNetworth");

        Pattern pattern = Pattern.compile("^\\b[A-z]+\\b( \\b[A-z]*\\b)?$");
        Matcher matcher = pattern.matcher(make.getMakename());

        if (!matcher.matches()) {
            errors.rejectValue("makename", "invalidMakename");
        }

        if (make.getNetworth() < 0) {
            errors.rejectValue("networth", "invalidNetworth");
        }
    }
}
