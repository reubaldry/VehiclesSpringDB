package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.CURRENCY_FIELDS;

public class Currency implements DbPojo{
    @Id
    private int currencyid;
    private String currencyname;
    private String currencysymbol;

    private List<StringField> fields = new ArrayList<>();
    private StringField[] values = new StringField[CURRENCY_FIELDS.length];

    public Currency(int currencyid, String currencyname, String currencysymbol) {
        this.currencyid = currencyid;
        this.currencyname = currencyname;
        this.currencysymbol = currencysymbol;

        for (String field : CURRENCY_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Currency() {
        for (String field : CURRENCY_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public int getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(int currencyid) {
        this.currencyid = currencyid;
        values[0] = new StringField("" + currencyid);
    }

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname;
        values[1] = new StringField(currencyname);
    }

    public String getCurrencysymbol() {
        return currencysymbol;
    }

    public void setCurrencysymbol(String currencysymbol) {
        this.currencysymbol = currencysymbol;
        values[2] = new StringField(currencysymbol);
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
