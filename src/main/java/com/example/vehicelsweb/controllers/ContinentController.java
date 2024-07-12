package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.ContinentDao;
import com.example.vehicelsweb.DbPOJOs.Continent;
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
public class ContinentController {
    @Autowired
    Validator continentValidator;
    @Autowired
    private ContinentDao continentDao;

    @InitBinder("continent")
    private void initContinentBinder(WebDataBinder binder) {
        binder.setValidator(continentValidator);
    }

    @GetMapping("/insert/continent")
    public String insertContinent(@ModelAttribute("errors") ArrayList<String> errors, Model model) {

        model.addAttribute("continent", new Continent());

        return "insertPages/continentinsert";
    }

    @PostMapping("/insert/continent")
    public RedirectView submitContinent(@ModelAttribute("continent") @Validated Continent continent,
                                        BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> errors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> fielderrors = new ArrayList<>();

            for (FieldError error : errors) {
                fielderrors.add(error.getField());
            }

            redirectAttributes.addFlashAttribute("errors", fielderrors);

            return new RedirectView("/insert/continent");
        }

        continentDao.save(continent);

        return new RedirectView("/home");
    }
}
