/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.web.dao.FollowUpDAO;
import com.mnzit.web.entity.FollowUp;
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
public class FollowUpDAOImpl implements FollowUpDAO {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<FollowUp> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(FollowUp model) {
        String sql = "INSERT INTO follow_ups(message,client_id) VALUES(?,?)";
        return template.update(sql, new Object[]{model.getMessage(), model.getClientId()});
    }

    @Override
    public int update(FollowUp model) {
        String sql = "UPDATE follow_ups SET message=? WHERE id=?";
        return template.update(sql, new Object[]{model.getMessage(),model.getId()});
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM follow_ups WHERE id=?";
        return template.update(sql, new Object[]{id});
    }

    @Override
    public FollowUp getById(int id) {
        String sql = "SELECT * FROM follow_ups where id=?";
        return template.queryForObject(sql, new FollowUpMapper(), new Object[]{id});
    }

    @Override
    public List<FollowUp> getMultipleById(int id) {
        String sql = "SELECT * FROM follow_ups where client_id=?";
        return template.query(sql, new Object[]{id}, new FollowUpMapper());
    }

    private class FollowUpMapper implements RowMapper<FollowUp> {

        @Override
        public FollowUp mapRow(ResultSet rs, int i) throws SQLException {
            FollowUp followUp = new FollowUp();
            followUp.setId(rs.getInt("id"));
            followUp.setMessage(rs.getString("message"));
            followUp.setClientId(rs.getInt("client_id"));
            followUp.setAddedDate(rs.getDate("added_date"));
            return followUp;
        }

    }

}
