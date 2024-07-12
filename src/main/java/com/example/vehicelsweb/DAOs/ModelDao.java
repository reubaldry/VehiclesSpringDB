package com.example.vehicelsweb.DAOs;

import com.example.vehicelsweb.DAOs.rowMappers.ModelRowMapper;
import com.example.vehicelsweb.DbPOJOs.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ModelDao implements ObjectDao<Model>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Model> getAllObjects() {
        String sql = "select * from model";

        return jdbcTemplate.query(sql, new ModelRowMapper());
    }

    @Override
    public void save(Model model) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("model").usingGeneratedKeyColumns("carmodelid");


        Map<String, Object> parameters = new HashMap<>(10);

        parameters.put("modelfueltype", model.getModelfueltype());
        parameters.put("typeofvehicle", model.getTypeofvehicle());
        parameters.put("manufacturelocation", model.getManufacturelocation());
        parameters.put("carmake", model.getCarmake());
        parameters.put("modelname", model.getModelname());
        parameters.put("stillproduced", model.isStillproduced());
        parameters.put("numberofcylinders", model.getNumberofcylinders());
        parameters.put("enginesize", model.getEnginesize());
        parameters.put("numberofdoors", model.getNumberofdoors());
        parameters.put("iselectric", model.isIselectric());

        simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
