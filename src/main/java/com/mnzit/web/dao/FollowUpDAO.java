/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao;

import com.mnzit.web.entity.FollowUp;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface FollowUpDAO extends GenericDAO<FollowUp>{
    
    List<FollowUp> getMultipleById(int id);
}
