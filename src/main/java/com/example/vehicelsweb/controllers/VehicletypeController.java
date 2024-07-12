package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.VehicletypeDao;
import com.example.vehicelsweb.DbPOJOs.Vehicletype;
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
public class VehicletypeController {

    @Autowired
    Validator vehicletypeValidator;
    @Autowired
    private VehicletypeDao vehicletypeDao;

    @InitBinder("vehicletype")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(vehicletypeValidator);
    }

    @GetMapping("/insert/vehicletype")
    public String insertVehicletype(@ModelAttribute("errors")ArrayList<String> errors, Model model) {

        model.addAttribute("vehicletype", new Vehicletype());

        return "insertPages/vehicletypeinsert";
    }

    @PostMapping("/insert/vehicletype")
    public RedirectView submitMake(@ModelAttribute("vehicletype") @Validated Vehicletype vehicletype,
                                   BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> errors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> fieldErrors = new ArrayList<>();

            for (FieldError error : errors) {
                fieldErrors.add(error.getField());
            }

            redirectAttributes.addFlashAttribute("errors", fieldErrors);
            return new RedirectView("/insert/vehicletype");
        }

        vehicletypeDao.save(vehicletype);

        return new RedirectView("/insert/success");
    }
}
