package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.ContinentDao;
import com.example.vehicelsweb.DAOs.CountryDao;
import com.example.vehicelsweb.DbPOJOs.Country;
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
public class CountryController {

    @Autowired
    Validator countryValidator;

    @Autowired
    private ContinentDao continentDao;
    @Autowired
    private CountryDao countryDao;

    @InitBinder("country")
    private void initCountryBinder(WebDataBinder binder) {
        binder.setValidator(countryValidator);
    }

    @GetMapping("/insert/country")
    public String insertCountry(@ModelAttribute("errors") ArrayList<String> errors, Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("continents", continentDao.getAllObjects());

        return "insertPages/countryinsert";
    }

    @PostMapping("/insert/country")
    public RedirectView submitCountry(@ModelAttribute("country") @Validated Country country, BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> errors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> fielderrors = new ArrayList<>();

            for (FieldError error : errors) {
                fielderrors.add(error.getField());
            }

            redirectAttributes.addFlashAttribute("errors", fielderrors);

            return new RedirectView("/insert/country");
        }

        countryDao.save(country);

        return new RedirectView("/home");
    }
}
