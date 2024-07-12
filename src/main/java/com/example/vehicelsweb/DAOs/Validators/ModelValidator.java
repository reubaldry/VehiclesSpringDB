package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Model;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ModelValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Model.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Model model = (Model) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelname", "emptyModelName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberofcylinders", "emptyNumberofcylinders");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "enginesize", "emptyEnginesize");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberofdoors", "emptyNumberofdoors");

        Pattern pattern = Pattern.compile("^\\b[A-z]+\\b( \\b[A-z]*\\b)?$");
        Matcher matcher = pattern.matcher(model.getModelname());

        if (!matcher.matches()) {
            errors.rejectValue("modelname", "invalidModelName");
        }

        if (model.getNumberofcylinders() < 0) {
            errors.rejectValue("numberofcylinders", "invalidNumberofcylinders");
        }

        if (model.getEnginesize() < 0) {
            errors.rejectValue("enginesize", "invalidEnginesize");
        }

        if (model.getNumberofdoors() < 1) {
            errors.rejectValue("numberofdoors", "invalidNumberofdoors");
        }
    }
}
