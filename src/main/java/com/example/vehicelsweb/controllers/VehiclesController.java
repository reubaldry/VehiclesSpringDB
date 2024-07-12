package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.StringField;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

import static com.example.vehicelsweb.Utils.*;

@Controller
public class VehiclesController {

    @GetMapping("/home")
    public String actionDropdown(Model model) {
        List<String> actions = new ArrayList<>();
        actions.add(INSERT);
        actions.add(SELECT);
        model.addAttribute("actions", actions);
        model.addAttribute("selection", new StringField());
        return "selectAction";
    }

    @PostMapping("/home")
    public RedirectView actionAdd(@ModelAttribute StringField stringField, Model model) {

        if (stringField.getFieldValue().equals(INSERT)) {
            return new RedirectView("/insert");
        } else if (stringField.getFieldValue().equals(SELECT)) {
            return new RedirectView("/select");
        }

        else {
            return new RedirectView("/insert/success");
        }
    }
}
