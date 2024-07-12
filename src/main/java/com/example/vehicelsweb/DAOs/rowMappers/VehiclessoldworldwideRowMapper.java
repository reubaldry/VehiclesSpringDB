package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Vehiclessoldworldwide;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiclessoldworldwideRowMapper implements RowMapper {
    @Override
    public Vehiclessoldworldwide mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vehiclessoldworldwide vw = new Vehiclessoldworldwide();

        vw.setVehiclessoldid(rs.getInt("vehiclessoldid"));
        vw.setCarmodel(rs.getInt("carmodel"));
        vw.setCurrency(rs.getInt("currency"));
        vw.setCountrysoldin(rs.getInt("countrysoldin"));
        vw.setAmountsoldfor(rs.getInt("amountsoldfor"));

        return vw;
    }
}
