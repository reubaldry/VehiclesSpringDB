package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.CONTINENT_FIELDS;

public class Continent implements DbPojo{
    @Id
    private int continentid;
    private String continentname;

    private List<StringField> fields = new ArrayList<>();
    private StringField[] values = new StringField[2];

    public Continent(int continentid, String continentname) {
        this.continentid = continentid;
        this.continentname = continentname;

        for (String field : CONTINENT_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Continent() {
        for (String field : CONTINENT_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public int getContinentid() {
        return continentid;
    }

    public void setContinentid(int continentid) {
        this.continentid = continentid;
        values[0] = new StringField(continentid + "");
    }

    public String getContinentname() {
        return continentname;
    }

    public void setContinentname(String continentname) {
        this.continentname = continentname;
        values[1] = new StringField(continentname);
    }

    @Override
    public List<StringField> getFields() {
        return fields;
    }

    @Override
    public List<StringField> getValues() {
        return Arrays.stream(values).toList();
    }
}
