/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.web.dao.ClientDAO;
import com.mnzit.web.entity.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mnzit
 */
@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    JdbcTemplate template;
    
    @Autowired
    FollowUpDAOImpl followUpDAOImpl;

    @Override
    public List<Client> getAll() {
        String sql = "SELECT * FROM client";
        return template.query(sql, new ClientMapper());
    }

    @Override
    public int insert(Client model) {
        String sql = "INSERT INTO client(first_name,last_name,email,contact_no,status) VALUES(?,?,?,?,?)";
        return template.update(sql, new Object[]{model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNo(), model.isStatus()});
    }

    @Override
    public int update(Client model) {
        String sql = "UPDATE client SET first_name=?,last_name=?,email=?,contact_no=?,status=?,modified_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNo(), model.isStatus(), model.getId()});
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM client WHERE id=?";
        return template.update(sql, new Object[]{id});
    }

    @Override
    public Client getById(int id) {
        String sql = "SELECT * FROM client WHERE id=?";
        return template.queryForObject(sql, new ClientMapper(), new Object[]{id});
    }

    private class ClientMapper implements RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet rs, int i) throws SQLException {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setFirstName(rs.getString("first_name"));
            client.setLastName(rs.getString("last_name"));
            client.setEmail(rs.getString("email"));
            client.setContactNo(rs.getString("contact_no"));
            client.setStatus(rs.getBoolean("status"));
            client.setAddedDate(rs.getDate("added_date"));
            client.setFollowUps( followUpDAOImpl.getMultipleById(rs.getInt("id")).size());
            return client;
        }

    }

}
