/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller;

import com.mnzit.web.dao.StudentDAO;
import com.mnzit.web.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mnzit
 */
@Controller
@RequestMapping(value = "/students")
public class StudentController {
    
    @Autowired
    private StudentDAO studentDAO;
   
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("students", studentDAO.getAll());
        return "student/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "student/add";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentDAO.getById(id));
        return "student/edit";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("Student") Student student) {
        if (student.getId() < 1) {
            studentDAO.insert(student);
        } else {
            studentDAO.update(student);
        }
        return "redirect:/students";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        studentDAO.delete(id);
        return "redirect:/students";
    }

}
