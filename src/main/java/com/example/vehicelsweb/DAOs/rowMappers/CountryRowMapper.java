package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.COUNTRY_FIELDS;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();

        country.setCountryid(rs.getInt(COUNTRY_FIELDS[0]));
        country.setContinent(rs.getInt(COUNTRY_FIELDS[1]));
        country.setCountryname(rs.getString(COUNTRY_FIELDS[2]));

        return country;
    }
}
