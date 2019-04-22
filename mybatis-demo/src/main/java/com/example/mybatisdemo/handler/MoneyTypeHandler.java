package com.example.mybatisdemo.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoneyTypeHandler extends BaseTypeHandler<Money> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Money money, JdbcType jdbcType) throws SQLException {
        ps.setLong(i,money.getAmountMinorLong());
    }

    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseMoney(rs.getLong(columnName));
    }

    @Override
    public Money getNullableResult(ResultSet rs, int i) throws SQLException {
        return parseMoney(rs.getLong(i));
    }

    @Override
    public Money getNullableResult(CallableStatement cs, int i) throws SQLException {
        return parseMoney(cs.getLong(i));
    }
    public Money parseMoney(Long value){
        return Money.of(CurrencyUnit.of("CNY"),value/100.0);
    }
}
