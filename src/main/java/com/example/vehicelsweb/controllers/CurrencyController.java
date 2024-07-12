package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.CurrencyDao;
import com.example.vehicelsweb.DbPOJOs.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class CurrencyController {

    @Autowired
    Validator currencyValidator;
    @Autowired
    private CurrencyDao currencyDao;

    @InitBinder("currency")
    private void initCurrencyBinder(WebDataBinder binder) {
        binder.setValidator(currencyValidator);
    }

    @GetMapping("/insert/currency")
    public String insertCurrency(@ModelAttribute("errors") ArrayList<String> errors, Model model) {
        model.addAttribute("currency", new Currency());

        return "insertPages/currencyinsert";
    }

    @PostMapping("/insert/currency")
    public RedirectView submitCurrency(@ModelAttribute("currency") @Validated Currency currency, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> errors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> fielderrors = new ArrayList<>();

            for (FieldError error : errors) {
                fielderrors.add(error.getField());
            }

            redirectAttributes.addFlashAttribute("errors", fielderrors);

            return new RedirectView("/insert/currency");
        }

        currencyDao.save(currency);

        return new RedirectView("/insert/success");
    }
}
