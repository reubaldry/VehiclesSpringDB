package com.example.vehicelsweb.DAOs.Validators;

import com.example.vehicelsweb.DbPOJOs.Currency;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CurrencyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Currency.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Currency currency = (Currency) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currencyname", "emptyCurrencyname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currencysymbol", "emptyCurrencysymbol");

        Pattern pattern = Pattern.compile("^\\b[A-z]+\\b( \\b[A-z]+\\b)*$");
        Matcher matcher = pattern.matcher(currency.getCurrencyname());

        if (!matcher.matches()) {
            errors.rejectValue("currencyname", "invalidCurrencyName");
        }

        pattern = Pattern.compile("^([^\\d\\s]){1,5}$");
        matcher = pattern.matcher(currency.getCurrencysymbol());

        if (!matcher.matches()) {
            errors.rejectValue("currencysymbol", "invalidCurrencySymbol");
        }
    }
}
