package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Model;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelRowMapper implements RowMapper<Model> {
    @Override
    public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
        Model model = new Model();

        model.setCarmodelid(rs.getInt("carmodelid"));
        model.setModelfueltype(rs.getInt("modelfueltype"));
        model.setTypeofvehicle(rs.getInt("typeofvehicle"));
        model.setManufacturelocation(rs.getInt("manufacturelocation"));
        model.setCarmake(rs.getInt("carmake"));
        model.setModelname(rs.getString("modelname"));
        model.setStillproduced(rs.getBoolean("stillproduced"));
        model.setNumberofcylinders(rs.getInt("numberofcylinders"));
        model.setEnginesize(rs.getInt("enginesize"));
        model.setNumberofdoors(rs.getInt("numberofdoors"));
        model.setIselectric(rs.getBoolean("iselectric"));

        return model;
    }
}
