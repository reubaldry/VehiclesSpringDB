package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;

import java.util.List;

public interface DbPojo {
    List<StringField> getFields();
    List<StringField> getValues();
}
