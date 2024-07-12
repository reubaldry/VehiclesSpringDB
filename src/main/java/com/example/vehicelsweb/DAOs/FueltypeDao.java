package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DbPOJOs.Continent;
import com.example.vehicelsweb.DbPOJOs.Fueltype;
import com.example.vehicelsweb.DAOs.rowMappers.FueltypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FueltypeDao implements ObjectDao<Fueltype>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Fueltype> getAllObjects() {
        String sql = "select * from fueltype";

        return jdbcTemplate.query(sql, new FueltypeRowMapper());
    }

    @Override
    public void save(Fueltype fueltype) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("fueltype").usingGeneratedKeyColumns("fueltypeid");

        Map<String, Object> parameters = new HashMap<>(1);

        parameters.put("fueltypename", fueltype.getFueltypename());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
