package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.FUELTYPE_FIELDS;

public class Fueltype implements DbPojo{
    @Id
    private int fueltypeid;
    private String fueltypename;

    private final List<StringField> fields = new ArrayList<>();
    private final StringField[] values = new StringField[FUELTYPE_FIELDS.length];

    public Fueltype(String fueltypename, int fueltypeid) {
        this.fueltypename = fueltypename;
        this.fueltypeid = fueltypeid;

        for (String field : FUELTYPE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Fueltype() {
        for (String field : FUELTYPE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public int getFueltypeid() {
        return fueltypeid;
    }

    public void setFueltypeid(int fueltypeid) {
        this.fueltypeid = fueltypeid;
        values[0] = new StringField("" + fueltypeid);
    }

    public String getFueltypename() {
        return fueltypename;
    }

    public void setFueltypename(String fueltypename) {
        this.fueltypename = fueltypename;
        values[1] = new StringField(fueltypename);
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
