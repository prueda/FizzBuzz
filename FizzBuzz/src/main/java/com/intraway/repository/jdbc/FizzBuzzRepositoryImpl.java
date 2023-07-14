package com.intraway.repository.jdbc;

import com.intraway.domain.FizzBuzz;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FizzBuzzRepositoryImpl implements FizzBuzzRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String INSERT_FIZZ_BUZZ = " INSERT INTO FIZZ_BUZZ " +
            " (TIMESTAMP, " +
            " DESCRIPTION, " +
            " LIST) " +
            " VALUES " +
            " (:TIMESTAMP, " +
            " :DESCRIPTION, " +
            " :LIST) " ;

    private static final String SELECT_FIZZ_BUZZ = " SELECT * FROM FIZZ_BUZZ " +
            " WHERE " +
            " TIMESTAMP = :TIMESTAMP AND " +
            " DESCRIPTION = :DESCRIPTION AND " +
            " LIST = :LIST ";

    static final RowMapper<FizzBuzz> FIZZ_BUZZ_ROW_MAPPER = (rs, rowNum) -> 
         FizzBuzz.builder()
                .timestamp(Timestamp.valueOf(rs.getString("TIMESTAMP")))
                .code(String.format("%03d", rs.getInt("CODE")))
                .description(rs.getString("DESCRIPTION"))
                .list(rs.getString("LIST"))
                .build();
    
    @Autowired
    public FizzBuzzRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addFizzBuzz(FizzBuzz fizzBuzz) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("TIMESTAMP", fizzBuzz.getTimestamp())
                .addValue("DESCRIPTION", fizzBuzz.getDescription())
                .addValue("LIST", fizzBuzz.getList())
                .addValue("STATUS", fizzBuzz.getList())
                .addValue("ERROR", fizzBuzz.getList())
                .addValue("EXCEPTION", fizzBuzz.getList())
                .addValue("MESSAGE", fizzBuzz.getList())
                .addValue("PATH", fizzBuzz.getList());
        return jdbcTemplate.update(INSERT_FIZZ_BUZZ, params);
    }

    @Override
    public Optional<FizzBuzz> getFizzBuzz(FizzBuzz fizzBuzz) {
        FizzBuzz fizzBuzzResult;
        Timestamp fizzBuzzTimestamp = fizzBuzz.getTimestamp();
        fizzBuzzTimestamp.setNanos(0);
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("TIMESTAMP", fizzBuzzTimestamp)
                .addValue("DESCRIPTION", fizzBuzz.getDescription())
                .addValue("LIST", fizzBuzz.getList());
        try{
            fizzBuzzResult= jdbcTemplate.queryForObject(SELECT_FIZZ_BUZZ, params, FIZZ_BUZZ_ROW_MAPPER);
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
        return Optional.of(fizzBuzzResult);
    }
    
}

