package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.COUNTRY_FIELDS;

public class Country implements DbPojo{
    @Id
    private int countryid;
    private int continent;
    private String countryname;

    private final List<StringField> fields = new ArrayList<>();
    private final StringField[] values = new StringField[3];

    public Country(int countryid, int continent, String countryname) {
        this.countryid = countryid;
        this.continent = continent;
        this.countryname = countryname;

        for (String field : COUNTRY_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Country() {
        for (String field : COUNTRY_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
        values[0] = new StringField("" + countryid);
    }

    public int getContinent() {
        return continent;
    }

    public void setContinent(int continent) {
        this.continent = continent;
        values[1] = new StringField("" + continent);
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
        values[2] = new StringField(countryname);
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
