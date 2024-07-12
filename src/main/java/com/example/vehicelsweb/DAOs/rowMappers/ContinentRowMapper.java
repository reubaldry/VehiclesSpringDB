package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Continent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContinentRowMapper implements RowMapper<Continent> {
    @Override
    public Continent mapRow(ResultSet rs, int rowNum) throws SQLException {
        Continent continent = new Continent();

        continent.setContinentid(rs.getInt("continentid"));
        continent.setContinentname(rs.getString("continentname"));

        return continent;
    }
}
