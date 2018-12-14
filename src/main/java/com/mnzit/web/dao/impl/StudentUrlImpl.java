/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.web.dao.StudentDAO;
import com.mnzit.web.entity.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mnzit
 */
@Repository

public class StudentUrlImpl implements StudentDAO {

    @Override
    public List<Student> getAll() {

        List<Student> students = new ArrayList<Student>();
        try {
            URL url = new URL("http://samplecsvs.s3.amazonaws.com/SacramentocrimeJanuary2006.csv");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            int i = 1;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 5) {
                    Student s = new Student();
                    s.setId(i);
                    s.setFirstName(tokens[1]);
                    s.setLastName(tokens[2]);
                    s.setEmail(tokens[3]);
                    s.setContactNo(tokens[4]);
                    s.setStatus(true);
                    students.add(s);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public int insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
