package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Make;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MakeRowMapper implements RowMapper<Make> {
    @Override
    public Make mapRow(ResultSet rs, int rowNum) throws SQLException {
        Make make = new Make();

        make.setCarmakeid(rs.getInt("carmakeid"));
        make.setCountry(rs.getInt("country"));
        make.setMakename(rs.getString("makename"));
        make.setYearestablished(rs.getDate("yearestablished"));
        make.setNetworth(rs.getInt("networth"));

        return make;
    }
}
