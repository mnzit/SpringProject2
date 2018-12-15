/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.web.dao.StudentDAO;
import com.mnzit.web.entity.Student;
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
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Student> getAll(){
        String sql = "SELECT * FROM student";
        return template.query(sql, new StudentMapper());
    }

    @Override
    public int insert(Student model){
        String sql = "INSERT INTO student(first_name,last_name,email,contact_no,status) VALUES(?,?,?,?,?)";
        return template.update(sql, new Object[]{model.getFirstName(), model.getLastName(),
            model.getEmail(), model.getContactNo(),
            model.isStatus()});
    }

    @Override
    public int update(Student model){
        String sql = "UPDATE student SET first_name=?,last_name=?,email=?,contact_no=?,status=?,modified_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{model.getFirstName(), model.getLastName(),
            model.getEmail(), model.getContactNo(),
            model.isStatus(), model.getId()});
    }

    @Override
    public int delete(int id){
        String sql = "DELETE FROM student WHERE id=?";
        return template.update(sql, new Object[]{id});
    }

    @Override
    public Student getById(int id){
        String sql = "SELECT * FROM student WHERE id=?";
        return template.queryForObject(sql, new StudentMapper(), new Object[]{id});
    }

    private class StudentMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setContactNo(rs.getString("contact_no"));
            student.setAddedDate(rs.getDate("added_date"));
            student.setModifiedDate(rs.getDate("modified_date"));
            student.setStatus(rs.getBoolean("status"));
            return student;
        }

    }

}
