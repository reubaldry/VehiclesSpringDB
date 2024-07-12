package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DbPOJOs.Continent;
import com.example.vehicelsweb.DbPOJOs.Currency;

import com.example.vehicelsweb.DAOs.rowMappers.CurrencyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CurrencyDao implements ObjectDao<Currency> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Currency> getAllObjects() {
        String sql = "select * from currency";

        return jdbcTemplate.query(sql, new CurrencyRowMapper());
    }

    @Override
    public void save(Currency currency) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("currency").usingGeneratedKeyColumns("currencyid");


        Map<String, Object> parameters = new HashMap<>(1);

        parameters.put("currencyname", currency.getCurrencyname());
        parameters.put("currencysymbol", currency.getCurrencysymbol());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
