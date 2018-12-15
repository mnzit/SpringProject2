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
public class Client extends Entity{

    private String firstName,lastName, email, contactNo;
    private int followUps;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, String contactNo, int followUps, int id, Date addedDate, Date modifiedDate, boolean status) {
        super(id, addedDate, modifiedDate, status);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.followUps = followUps;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getFollowUps() {
        return followUps;
    }

    public void setFollowUps(int followUps) {
        this.followUps = followUps;
    }

    
}
