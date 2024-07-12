package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.FueltypeDao;
import com.example.vehicelsweb.DbPOJOs.Fueltype;
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
public class FueltypeController {

    @Autowired
    Validator fueltypeValidator;
    @Autowired
    private FueltypeDao fueltypeDao;

    @InitBinder("fueltype")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(fueltypeValidator);
    }

    @GetMapping("/insert/fueltype")
    public String insertFueltype(@ModelAttribute("errors") ArrayList<String> errors, Model model) {

        model.addAttribute("fueltype", new Fueltype());

        return "insertPages/fueltypeinsert";
    }

    @PostMapping("/insert/fueltype")
    public RedirectView submitFueltype(@ModelAttribute("fueltype") @Validated Fueltype fueltype, BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> errors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> fieldErrors = new ArrayList<>();

            for (FieldError error : errors) {
                fieldErrors.add(error.getField());
            }

            redirectAttributes.addFlashAttribute("errors", fieldErrors);
            return new RedirectView("/insert/fueltype");
        }

        fueltypeDao.save(fueltype);

        return new RedirectView("/home");
    }
}
