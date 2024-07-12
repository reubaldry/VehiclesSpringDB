package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Vehicletype;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicletypeRowMapper implements RowMapper {
    @Override
    public Vehicletype mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vehicletype vehicletype = new Vehicletype();

        vehicletype.setVehicletypeid(rs.getInt("vehicletypeid"));
        vehicletype.setVehicletypename(rs.getString("vehicletypename"));

        return vehicletype;
    }
}
