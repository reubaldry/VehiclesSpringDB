package com.example.vehicelsweb.DAOs.rowMappers;

import com.example.vehicelsweb.DbPOJOs.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyRowMapper implements RowMapper<Currency> {

    @Override
    public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
        Currency currency = new Currency();

        currency.setCurrencyid(rs.getInt("currencyid"));
        currency.setCurrencyname(rs.getString("currencyname"));
        currency.setCurrencysymbol(rs.getString("currencysymbol"));

        return currency;
    }
}
