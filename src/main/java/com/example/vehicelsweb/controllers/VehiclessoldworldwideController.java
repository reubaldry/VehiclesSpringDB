package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.CountryDao;
import com.example.vehicelsweb.DAOs.CurrencyDao;
import com.example.vehicelsweb.DAOs.ModelDao;
import com.example.vehicelsweb.DAOs.VehiclessoldworldwideDao;
import com.example.vehicelsweb.DbPOJOs.Make;
import com.example.vehicelsweb.DbPOJOs.Vehiclessoldworldwide;
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
public class VehiclessoldworldwideController {

    @Autowired
    Validator vehiclessoldworldwideValidator;
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private CurrencyDao currencyDao;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private VehiclessoldworldwideDao vehiclessoldworldwideDao;

    @InitBinder("vehiclessoldworldwide")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(vehiclessoldworldwideValidator);
    }

    @GetMapping("/insert/vehiclessoldworldwide")
    public String insertVehiclessoldworldwide(@ModelAttribute("errors")ArrayList<String> errors, Model model) {

        model.addAttribute("vehiclessoldworldwide", new Vehiclessoldworldwide());
        model.addAttribute("models", modelDao.getAllObjects());
        model.addAttribute("currencies", currencyDao.getAllObjects());
        model.addAttribute("countries", countryDao.getAllObjects());

        return "insertPages/vehiclessoldworldwideinsert";
    }

    @PostMapping("/insert/vehiclessoldworldwide")
    public RedirectView submitMake(@ModelAttribute("vehiclessoldworldwide") @Validated Vehiclessoldworldwide vehiclessoldworldwide,
                                   BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> errors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> fieldErrors = new ArrayList<>();

            for (FieldError error : errors) {
                fieldErrors.add(error.getField());
            }

            redirectAttributes.addFlashAttribute("errors", fieldErrors);
            return new RedirectView("/insert/vehiclessoldworldwide");
        }

        vehiclessoldworldwideDao.save(vehiclessoldworldwide);

        return new RedirectView("/home");
    }
}
