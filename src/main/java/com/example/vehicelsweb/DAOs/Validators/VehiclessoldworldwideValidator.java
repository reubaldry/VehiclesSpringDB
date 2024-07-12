package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Vehiclessoldworldwide;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class VehiclessoldworldwideValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Vehiclessoldworldwide.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Vehiclessoldworldwide vehicle = (Vehiclessoldworldwide) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amountsoldfor", "emptyAmount");

        if (vehicle.getAmountsoldfor() < 0) {
            errors.rejectValue("amountsoldfor", "invalidAmount");
        }
    }
}
