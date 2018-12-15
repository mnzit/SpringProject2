/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller;

import com.mnzit.web.dao.impl.FollowUpDAOImpl;
import com.mnzit.web.entity.FollowUp;
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
@RequestMapping(value = "clients/followup")
public class FollowUpController {

    @Autowired
    FollowUpDAOImpl followUpDAOImpl;

    @GetMapping("/{client_id}")
    public String index(Model model, @PathVariable("client_id") int client_id) {
        model.addAttribute("followups", followUpDAOImpl.getMultipleById(client_id));
        model.addAttribute("client_id", client_id);
        return "followup/index";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("FollowUp") FollowUp followUp) {
        followUpDAOImpl.insert(followUp);
        return "redirect:/clients";
    }
    
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        followUpDAOImpl.delete(id);
        return "redirect:/clients";
    }
}
