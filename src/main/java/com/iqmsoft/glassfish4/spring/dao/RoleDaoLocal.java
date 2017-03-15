package com.iqmsoft.glassfish4.spring.dao;

import javax.ejb.Local;

import com.iqmsoft.glassfish4.spring.models.Role;

@Local
public interface RoleDaoLocal {
    
    Role getRole(Integer id);
    
}
