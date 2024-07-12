package com.example.vehicelsweb.DbPOJOs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbUtils {

    public static final String CONTINENT = "continent";
    public static final String COUNTRY = "country";
    public static final String CURRENCY = "currency";
    public static final String FUELTYPE = "fueltype";
    public static final String MAKE = "make";
    public static final String MODEL = "model";
    public static final String VEHICLESSOLDWORLDWIDE = "vehiclessoldworldwide";
    public static final String VEHICLETYPE = "vehicletype";

    public static final List<String> TABLES = Arrays.asList(CONTINENT, COUNTRY, CURRENCY, FUELTYPE, MAKE, MODEL, VEHICLESSOLDWORLDWIDE, VEHICLETYPE);

    public static final String[] CONTINENT_FIELDS = {"continentid", "continentname"};
    public static final String[] COUNTRY_FIELDS = {"countryid", "continent", "countryname"};
    public static final String[] CURRENCY_FIELDS = {"currencyid", "currencyname", "currencysymbol"};
    public static final String[] FUELTYPE_FIELDS = {"fueltypeid", "fueltypename"};
    public static final String[] MAKE_FIELDS = {"carmakeid", "country", "makename", "yearestablished", "networth"};
    public static final String[] MODEL_FIELDS = {"carmodelid", "modelfueltype", "typeofvehicle", "manufacturelocation",
            "carmake", "modelname", "stillproduced", "numberofcylinders", "enginesize", "numberofdoors", "iselectric"};
    public static final String[] VEHICLESSOLDWORLDWIDE_FIELDS = {"vehiclessoldid", "carmodel", "currency",
            "countrysoldin", "amountsoldfor"};
    public static final String[] VEHICLETYPE_FIELDS = {"vehicletypeid", "vehicletypename"};

//    public static DbPojo getDbPojo(String tableName) {
//        switch (tableName) {
//            case CONTINENT -> {
//                return new Continent();
//            }
//            case COUNTRY -> {
//                return new Country();
//            }
//            case CURRENCY -> {
//                return new Currency();
//            }
//            case FUELTYPE -> {
//                return new Fueltype();
//            }
//            case MAKE -> {
//                return new Make();
//            }
//            case MODEL -> {
//                return new Model();
//            }
//            case VEHICLESSOLDWORLDWIDE -> {
//                return new Vehiclessoldworldwide();
//            }
//            case VEHICLETYPE -> {
//                return new Vehicletype();
//            }
//        }
//    }
}
