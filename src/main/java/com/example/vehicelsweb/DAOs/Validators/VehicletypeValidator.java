package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Vehicletype;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class VehicletypeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Vehicletype.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Vehicletype vehicletype = (Vehicletype) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicletypename", "emptyVehicleypename");

        Pattern pattern = Pattern.compile("^\\b[A-z]+\\b( \\b[A-z]*\\b)?$");
        Matcher matcher = pattern.matcher(vehicletype.getVehicletypename());

        if (!matcher.matches()) {
            errors.rejectValue("vehicletypename", "invalidVehicleTypename");
        }
    }
}
