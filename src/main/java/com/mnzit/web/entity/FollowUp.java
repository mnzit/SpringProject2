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
public class FollowUp extends Entity{
    private int clientId;
    private String message;

    public FollowUp() {
    }

    public FollowUp(int clientId, String message, int id, Date addedDate, Date modifiedDate, boolean status) {
        super(id, addedDate, modifiedDate, status);
        this.clientId = clientId;
        this.message = message;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
