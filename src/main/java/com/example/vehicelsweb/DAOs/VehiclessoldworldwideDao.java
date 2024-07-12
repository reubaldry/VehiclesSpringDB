package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DAOs.rowMappers.VehiclessoldworldwideRowMapper;
import com.example.vehicelsweb.DbPOJOs.Continent;
import com.example.vehicelsweb.DbPOJOs.Vehiclessoldworldwide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VehiclessoldworldwideDao implements ObjectDao<Vehiclessoldworldwide> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Vehiclessoldworldwide> getAllObjects() {
        String sql = "select * from vehiclessoldworldwide";
        return jdbcTemplate.query(sql, new VehiclessoldworldwideRowMapper());
    }

    @Override
    public void save(Vehiclessoldworldwide vehiclessoldworldwide) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("vehiclessoldworldwide").usingGeneratedKeyColumns("vehiclessoldid");


        Map<String, Object> parameters = new HashMap<>(4);

        parameters.put("carmodel", vehiclessoldworldwide.getCarmodel());
        parameters.put("currency", vehiclessoldworldwide.getCurrency());
        parameters.put("countrysoldin", vehiclessoldworldwide.getCountrysoldin());
        parameters.put("amountsoldfor", vehiclessoldworldwide.getAmountsoldfor());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
