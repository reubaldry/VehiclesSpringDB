package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DbPOJOs.Country;
import com.example.vehicelsweb.DAOs.rowMappers.CountryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class CountryDao implements ObjectDao<Country>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> getAllObjects() {
        String sql = "SELECT * FROM country";

        return jdbcTemplate.query(sql, new CountryRowMapper());
    }

    @Override
    public void save(Country country) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("country").usingGeneratedKeyColumns("countryid");

        Map<String, Object> parameters = new HashMap<>(2);

        parameters.put("continent", country.getContinent());
        parameters.put("countryname", country.getCountryname());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}