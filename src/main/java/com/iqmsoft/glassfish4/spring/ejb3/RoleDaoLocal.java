package com.iqmsoft.glassfish4.spring.ejb3;

import javax.ejb.Local;

import com.iqmsoft.glassfish4.spring.models.Role;

@Local
public interface RoleDaoLocal {
    
    Role getRole(Integer id);
    
}
