package com.example.demo.Repository;

import com.example.demo.Models.Manager;
import com.example.demo.Models.Seller;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerRepositoryH2 implements SellerRepository {

    private static final String CREATE = """
                        insert into sellers (sellerId,managerId, firstname, lastname, phone, salary)
                        values (:sellerId,:managerId, :firstname, :lastname, :phone, :salary)
            """;
    private static final String UPDATE = """
            UPDATE sellers
            SET managerId=:managerId,
            firstname = :firstname,
            lastname = :lastname,
            phone = :phone,
            salary = :salary
            WHERE sellerId = :sellerId
            """;

    private final RowMapper<Seller> rowMapper = new DataClassRowMapper<>(Seller.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public SellerRepositoryH2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Seller read(Integer sellerId) {
        try {
            return jdbcTemplate.queryForObject("select * from sellers where sellerId = ?", rowMapper, sellerId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Seller with id = [" + sellerId + "] not found", e);
        }
    }

    @Override
    public List<Seller> readAll() {
        return jdbcTemplate.query("select * from sellers", rowMapper);
    }

    @Override
    public void create(Seller seller) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(seller);
        namedParameterJdbcTemplate.update(CREATE, paramsSource);
    }

    @Override
    public void update(Seller seller, Integer sellerId) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(seller);
        namedParameterJdbcTemplate.update(UPDATE, paramsSource);
    }

    @Override
    public void delete(Integer sellerId) {
        jdbcTemplate.update("DELETE FROM sellers where managerId = ?",sellerId);
    }

}
