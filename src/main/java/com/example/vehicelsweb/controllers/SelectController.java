package com.example.vehicelsweb.controllers;

import com.example.vehicelsweb.DAOs.*;
import com.example.vehicelsweb.DbPOJOs.*;
import com.example.vehicelsweb.StringField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.*;

@Controller
public class SelectController {

    @Autowired
    private ContinentDao continentDao;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private CurrencyDao currencyDao;
    @Autowired
    private FueltypeDao fueltypeDao;
    @Autowired
    private MakeDao makeDao;
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private VehiclessoldworldwideDao vehiclessoldworldwideDao;
    @Autowired
    private VehicletypeDao vehicletypeDao;

    @GetMapping("/select")
    public String selectTable(Model model) {
        List<String> tables = new ArrayList<>();
        tables = TABLES;

        model.addAttribute("tables", tables);
        model.addAttribute("selection", new StringField());

        return "select";
    }

    @PostMapping("/select")
    public RedirectView selectTable(@ModelAttribute StringField stringField, Model model, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("table", stringField.getFieldValue());

        switch (stringField.getFieldValue()) {
            case CONTINENT -> {
                List<Continent> continents = continentDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new Continent().getFields());
                redirectAttributes.addFlashAttribute("entries", continents);

                return new RedirectView("/viewtable");
            }
            case COUNTRY -> {
                List<Country> countries = countryDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new Country().getFields());
                redirectAttributes.addFlashAttribute("entries", countries);

                return new RedirectView("/viewtable");
            }
            case CURRENCY -> {
                List<Currency> currencies = currencyDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new Currency().getFields());
                redirectAttributes.addFlashAttribute("entries", currencies);

                return new RedirectView("/viewtable");
            }
            case FUELTYPE -> {
                List<Fueltype> fueltypes = fueltypeDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new Fueltype().getFields());
                redirectAttributes.addFlashAttribute("entries", fueltypes);

                return new RedirectView("/viewtable");
            }
            case MAKE -> {
                List<Make> makes = makeDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new Make().getFields());
                redirectAttributes.addFlashAttribute("entries", makes);

                return new RedirectView("/viewtable");
            }
            case MODEL -> {
                List<com.example.vehicelsweb.DbPOJOs.Model> models = modelDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new com.example.vehicelsweb.DbPOJOs.Model().getFields());
                redirectAttributes.addFlashAttribute("entries", models);

                return new RedirectView("/viewtable");
            }
            case VEHICLESSOLDWORLDWIDE -> {
                List<Vehiclessoldworldwide> vehiclessold = vehiclessoldworldwideDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new Vehiclessoldworldwide().getFields());
                redirectAttributes.addFlashAttribute("entries", vehiclessold);

                return new RedirectView("/viewtable");
            }
            case VEHICLETYPE -> {
                List<Vehicletype> vehicletypes = vehicletypeDao.getAllObjects();

                redirectAttributes.addFlashAttribute("fields", new Vehicletype().getFields());
                redirectAttributes.addFlashAttribute("entries", vehicletypes);

                return new RedirectView("/viewtable");
            }
            default -> {

                return new RedirectView("/select");
            }
        }
    }

    @GetMapping("/viewtable")
    public String viewTable(@ModelAttribute("table") String table, @ModelAttribute("entries") List<DbPojo> entries,
                            @ModelAttribute("fields") List<StringField> fields, Model model) {
        model.addAttribute("table", table);
        model.addAttribute("entries", entries);
        model.addAttribute("fields", fields);

        System.out.println(table);

        return "displaySelection";
    }

    @PostMapping("/viewtable")
    public RedirectView goHome() {
        return new RedirectView("/home");
    }

}
