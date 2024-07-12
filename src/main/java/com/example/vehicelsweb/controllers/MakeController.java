package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.CountryDao;
import com.example.vehicelsweb.DAOs.MakeDao;
import com.example.vehicelsweb.DbPOJOs.Make;
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
public class MakeController {

    @Autowired
    Validator makeValidator;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private MakeDao makeDao;

    @InitBinder("make")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(makeValidator);
    }

    @GetMapping("/insert/make")
    public String inputMake(@ModelAttribute("errors")ArrayList<String> errors, Model model) {

        model.addAttribute("make", new Make());
        model.addAttribute("countries", countryDao.getAllObjects());

        return "insertPages/makeinsert";
    }

    @PostMapping("/insert/make")
    public RedirectView submitMake(@ModelAttribute("make") @Validated Make make, BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> errors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> fieldErrors = new ArrayList<>();

            for (FieldError error : errors) {
                fieldErrors.add(error.getField());
            }

            redirectAttributes.addFlashAttribute("errors", fieldErrors);
            return new RedirectView("/insert/make");
        }

        makeDao.save(make);

        return new RedirectView("/home");
    }
}
