package com.iqmsoft.glassfish4.spring.services;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.iqmsoft.glassfish4.spring.dao.RoleDaoLocal;
import com.iqmsoft.glassfish4.spring.models.Role;

@Service
@Transactional
public class RoleService implements RoleServiceInterface{
    
    @EJB(mappedName = "RoleDao")
    private RoleDaoLocal roleDAO;
 
    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }
}
