/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller;

import com.mnzit.web.dao.impl.FollowUpDAOImpl;
import com.mnzit.web.entity.FollowUp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mnzit
 */
@RestController
@RequestMapping(value = "clients/followup")
public class FollowUpController {

    @Autowired
    FollowUpDAOImpl followUpDAOImpl;

    @GetMapping("/{client_id}")
    public List index(Model model, @PathVariable("client_id") int client_id) {
//        model.addAttribute("followups", followUpDAOImpl.getMultipleById(client_id));
//        model.addAttribute("client_id", client_id);
        return followUpDAOImpl.getMultipleById(client_id);
    }

    @PostMapping(value = "/{client_id}/save")
    public String save(@PathVariable("client_id") int client_id, @ModelAttribute("FollowUp") FollowUp followUp) {
        if (followUp.getId() < 1) {
            followUpDAOImpl.insert(followUp);
        } else {
            followUpDAOImpl.update(followUp);
        }
        return "redirect:/clients/followup/" + client_id;
    }

    @GetMapping(value = "/{client_id}/delete/{id}")
    public String delete(@PathVariable("client_id") int client_id, @PathVariable("id") int id) {
        followUpDAOImpl.delete(id);
        return "redirect:/clients/followup/" + client_id;
    }

    @GetMapping(value = "/{client_id}/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("followup", followUpDAOImpl.getById(id));
        return "followup/edit";
    }
}
