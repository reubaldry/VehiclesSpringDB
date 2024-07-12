package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DbPOJOs.Continent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.vehicelsweb.DAOs.rowMappers.ContinentRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class ContinentDao implements ObjectDao<Continent> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Continent> getAllObjects() {
        String sql = "SELECT * FROM continent";

        return jdbcTemplate.query(sql, new ContinentRowMapper());
    }

    @Override
    public void save(Continent continent) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("continent").usingGeneratedKeyColumns("continentid");


        Map<String, Object> parameters = new HashMap<>(1);

        parameters.put("continentname", continent.getContinentname());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
