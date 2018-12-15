/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.controller;

import com.mnzit.web.entity.Client;
import com.mnzit.web.service.impl.ClientServiceImpl;
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
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientServiceImpl clientServiceImpl;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("clients", clientServiceImpl.getAll());
        return "client/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "client/add";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientServiceImpl.getById(id));
        return "client/edit";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("Client") Client client) {
        if (client.getId() < 1) {
            clientServiceImpl.insert(client);
        } else {
            clientServiceImpl.update(client);
        }
        return "redirect:/clients";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        clientServiceImpl.delete(id);
        return "redirect:/clients";
    }
}
