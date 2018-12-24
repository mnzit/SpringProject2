/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.web.dao.StudentDAO;
import com.mnzit.web.entity.Student;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mnzit
 */

@Repository(value = "studentHDAO")
public class StudentHibernateImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<Student> getAll() {
        session = sessionFactory.openSession();
        CriteriaQuery query = session.getCriteriaBuilder().createQuery(Student.class);
        query.from(Student.class);
        return session.createQuery(query).getResultList();
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
