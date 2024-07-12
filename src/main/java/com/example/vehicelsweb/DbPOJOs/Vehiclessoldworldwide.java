package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.VEHICLESSOLDWORLDWIDE_FIELDS;

public class Vehiclessoldworldwide implements DbPojo{
    @Id
    private int vehiclessoldid;
    private int carmodel;
    private int currency;
    private int countrysoldin;
    private int amountsoldfor;

    private List<StringField> fields = new ArrayList<>();
    private StringField[] values = new StringField[VEHICLESSOLDWORLDWIDE_FIELDS.length];

    public Vehiclessoldworldwide(int vehiclessoldid, int carmodel, int currency, int countrysoldin, int amountsoldfor) {
        this.vehiclessoldid = vehiclessoldid;
        this.carmodel = carmodel;
        this.currency = currency;
        this.countrysoldin = countrysoldin;
        this.amountsoldfor = amountsoldfor;

        for (String field : VEHICLESSOLDWORLDWIDE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Vehiclessoldworldwide() {
        for (String field : VEHICLESSOLDWORLDWIDE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public int getVehiclessoldid() {
        return vehiclessoldid;
    }

    public void setVehiclessoldid(int vehiclessoldid) {
        this.vehiclessoldid = vehiclessoldid;
        values[0] = new StringField("" + vehiclessoldid);
    }

    public int getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(int carmodel) {
        this.carmodel = carmodel;
        values[1] = new StringField("" + carmodel);
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
        values[2] = new StringField("" + currency);
    }

    public int getCountrysoldin() {
        return countrysoldin;
    }

    public void setCountrysoldin(int countrysoldin) {
        this.countrysoldin = countrysoldin;
        values[3] = new StringField("" + countrysoldin);
    }

    public int getAmountsoldfor() {
        return amountsoldfor;
    }

    public void setAmountsoldfor(int amountsoldfor) {
        this.amountsoldfor = amountsoldfor;
        values[4] = new StringField("" + amountsoldfor);
    }

    @Override
    public List<StringField> getFields() {
        return fields;
    }

    @Override
    public List<StringField> getValues() {
        return List.of(values);
    }
}
