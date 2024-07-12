package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.*;
import com.example.vehicelsweb.DbPOJOs.Continent;
import com.example.vehicelsweb.DbPOJOs.Country;
import com.example.vehicelsweb.DbPOJOs.Currency;
import com.example.vehicelsweb.StringField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.TABLES;

@Controller
public class InsertController {

    @GetMapping("/insert")
    public String insertTables(Model model) {
        List<String> tables = new ArrayList<>();
        tables = TABLES;

        model.addAttribute("tables", tables);
        model.addAttribute("selection", new StringField());

        return "insert";
    }

    @PostMapping("/insert")
    public RedirectView insertInto(@ModelAttribute StringField table, Model model, RedirectAttributes redirectAttributes) {

        return new RedirectView("/insert/" + table.getFieldValue());
    }

}
