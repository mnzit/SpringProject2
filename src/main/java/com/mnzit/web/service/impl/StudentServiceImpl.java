/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.service.impl;

import com.mnzit.web.dao.StudentDAO;
import com.mnzit.web.dao.impl.StudentDAOImpl;
import com.mnzit.web.entity.Student;
import com.mnzit.web.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mnzit
 */
@Repository
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    StudentDAO studentDao;
    
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
    
    @Override
    public int insert(Student model) {
        return studentDao.insert(model);
    }
    
    @Override
    public int update(Student model) {
        return studentDao.update(model);
    }
    
    @Override
    public Student getById(int id) {
        return studentDao.getById(id);
    }
    
    @Override
    public int delete(int id) {
        return studentDao.delete(id);
    }
    
}
