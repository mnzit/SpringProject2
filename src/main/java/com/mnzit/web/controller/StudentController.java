/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller;

import com.mnzit.web.entity.Student;
import com.mnzit.web.service.impl.StudentServiceImpl;
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
    private StudentServiceImpl studentServiceImpl;
   
    @GetMapping()
    public String index(Model model) {
        for(Student student:studentServiceImpl.getAll()){
            student.getFirstName();
        }
        model.addAttribute("students", studentServiceImpl.getAll());
        return "student/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "student/add";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentServiceImpl.getById(id));
        return "student/edit";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("Student") Student student) {
        if (student.getId() < 1) {
            studentServiceImpl.insert(student);
        } else {
            studentServiceImpl.update(student);
        }
        return "redirect:/students";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        studentServiceImpl.delete(id);
        return "redirect:/students";
    }

}
