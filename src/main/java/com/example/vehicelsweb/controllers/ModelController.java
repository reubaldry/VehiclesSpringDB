package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.*;
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
public class ModelController {

    @Autowired
    Validator modelValidator;
    @Autowired
    private FueltypeDao fueltypeDao;
    @Autowired
    private VehicletypeDao vehicletypeDao;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private MakeDao makeDao;
    @Autowired
    private ModelDao modelDao;

    @InitBinder("model")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(modelValidator);
    }

    @GetMapping("/insert/model")
    public String insertModel(@ModelAttribute("errors") ArrayList<String> errors, Model model) {

        model.addAttribute("model", new com.example.vehicelsweb.DbPOJOs.Model());
        model.addAttribute("fueltypes", fueltypeDao.getAllObjects());
        model.addAttribute("vehicletypes", vehicletypeDao.getAllObjects());
        model.addAttribute("locations", countryDao.getAllObjects());
        model.addAttribute("makes", makeDao.getAllObjects());

        return "insertPages/modelinsert";
    }

    @PostMapping("/insert/model")
    public RedirectView submitModel(@ModelAttribute("model") @Validated com.example.vehicelsweb.DbPOJOs.Model model,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ArrayList<FieldError> fieldErrors = new ArrayList<>(bindingResult.getFieldErrors());
            ArrayList<String> errors = new ArrayList<>();

            for (FieldError fieldError : fieldErrors) {
                errors.add(fieldError.getField());
            }

            redirectAttributes.addFlashAttribute("errors", errors);
            return new RedirectView("/insert/model");

        }

        modelDao.save(model);

        return new RedirectView("/home");
    }

}
