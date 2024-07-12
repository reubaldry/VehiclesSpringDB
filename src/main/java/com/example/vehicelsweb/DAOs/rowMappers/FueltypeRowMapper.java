package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Fueltype;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FueltypeRowMapper implements RowMapper<Fueltype> {
    @Override
    public Fueltype mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fueltype fueltype = new Fueltype();

        fueltype.setFueltypeid(rs.getInt("fueltypeid"));
        fueltype.setFueltypename(rs.getString("fueltypename"));

        return fueltype;
    }
}
