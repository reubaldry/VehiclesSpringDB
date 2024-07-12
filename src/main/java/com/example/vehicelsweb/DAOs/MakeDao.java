package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DAOs.rowMappers.MakeRowMapper;
import com.example.vehicelsweb.DbPOJOs.Make;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MakeDao implements ObjectDao<Make>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Make> getAllObjects() {
        String sql = "SELECT * FROM make";

        return jdbcTemplate.query(sql, new MakeRowMapper());
    }

    @Override
    public void save(Make make) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("make").usingGeneratedKeyColumns("carmakeid");


        Map<String, Object> parameters = new HashMap<>(4);

        parameters.put("country", make.getCountry());
        parameters.put("makename", make.getMakename());
        parameters.put("yearestablished", make.getYearestablished());
        parameters.put("networth", make.getNetworth());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
