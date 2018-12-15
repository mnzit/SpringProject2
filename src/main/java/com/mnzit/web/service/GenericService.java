/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.service;

import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface GenericService<T> {

    List<T> getAll();

    int insert(T model);

    int update(T model);

    T getById(int id);

    int delete(int id);
}
