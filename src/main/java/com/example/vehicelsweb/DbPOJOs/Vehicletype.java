package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.VEHICLETYPE_FIELDS;

public class Vehicletype implements DbPojo{
    @Id
    private int vehicletypeid;
    private String vehicletypename;

    private final List<StringField> fields = new ArrayList<>();
    private final StringField[] values = new StringField[VEHICLETYPE_FIELDS.length];

    public Vehicletype(String vehicletypename, int vehicletypeid) {
        this.vehicletypename = vehicletypename;
        this.vehicletypeid = vehicletypeid;

        for (String field : VEHICLETYPE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Vehicletype() {
        for (String field : VEHICLETYPE_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public String getVehicletypename() {
        return vehicletypename;
    }

    public void setVehicletypename(String vehicletypename) {
        this.vehicletypename = vehicletypename;
        values[1] = new StringField(vehicletypename);
    }

    public int getVehicletypeid() {
        return vehicletypeid;
    }

    public void setVehicletypeid(int vehicletypeid) {
        this.vehicletypeid = vehicletypeid;
        values[0] = new StringField("" + vehicletypeid);
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
