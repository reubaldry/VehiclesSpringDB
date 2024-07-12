package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DAOs.rowMappers.VehicletypeRowMapper;
import com.example.vehicelsweb.DbPOJOs.Continent;
import com.example.vehicelsweb.DbPOJOs.Vehicletype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VehicletypeDao implements ObjectDao<Vehicletype> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Vehicletype> getAllObjects() {
        String sql = "select * from vehicletype";
        return jdbcTemplate.query(sql, new VehicletypeRowMapper());
    }

    @Override
    public void save(Vehicletype vehicletype) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("vehicletype").usingGeneratedKeyColumns("vehicletypeid");


        Map<String, Object> parameters = new HashMap<>(1);

        parameters.put("vehicletypename", vehicletype.getVehicletypename());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
