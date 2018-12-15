/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.entity;

import java.util.Date;

/**
 *
 * @author Mnzit
 */
public class Entity {

    private int id;
    private Date addedDate, modifiedDate;
    private boolean status;

    public Entity() {
    }

    public Entity(int id, Date addedDate, Date modifiedDate, boolean status) {
        this.id = id;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
