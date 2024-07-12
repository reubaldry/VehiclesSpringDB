package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.MAKE_FIELDS;

public class Make implements DbPojo{
    @Id
    private int carmakeid;
    private int country;
    private String makename;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearestablished;
    private int networth;
    private List<StringField> fields = new ArrayList<>();
    private StringField[] values = new StringField[MAKE_FIELDS.length];

    public Make(int carmakeid, int country, String makename, Date yearestablished, int networth) {
        this.carmakeid = carmakeid;
        this.country = country;
        this.makename = makename;
        this.yearestablished = yearestablished;
        this.networth = networth;

        for (String field : MAKE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Make() {
        for (String field : MAKE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public int getCarmakeid() {
        return carmakeid;
    }

    public void setCarmakeid(int carmakeid) {
        this.carmakeid = carmakeid;
        values[0] = new StringField(carmakeid + "");
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
        values[1] = new StringField(country + "");
    }

    public String getMakename() {
        return makename;
    }

    public void setMakename(String makename) {
        this.makename = makename;
        values[2] =  new StringField(makename);
    }

    public Date getYearestablished() {
        return yearestablished;
    }

    public void setYearestablished(Date yearestablished) {
        this.yearestablished = yearestablished;
        values[3] =  new StringField(yearestablished + "");
    }

    public int getNetworth() {
        return networth;
    }

    public void setNetworth(int networth) {
        this.networth = networth;
        values[4] =  new StringField(networth + "");
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
