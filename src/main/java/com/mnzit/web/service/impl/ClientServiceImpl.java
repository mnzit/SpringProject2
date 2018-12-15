/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.service.impl;

import com.mnzit.web.dao.impl.ClientDAOImpl;
import com.mnzit.web.entity.Client;
import com.mnzit.web.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mnzit
 */
@Repository
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientDAOImpl clientDAOImpl;
    
    @Override
    public List<Client> getAll() {
       return clientDAOImpl.getAll();
    }

    @Override
    public int insert(Client model) {
        return clientDAOImpl.insert(model);
    }

    @Override
    public int update(Client model) {
       return clientDAOImpl.update(model);
    }

    @Override
    public Client getById(int id) {
         return clientDAOImpl.getById(id);
    }

    @Override
    public int delete(int id) {
       return clientDAOImpl.delete(id);
    }
    
}
