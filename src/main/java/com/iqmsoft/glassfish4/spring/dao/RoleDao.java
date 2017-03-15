package com.iqmsoft.glassfish4.spring.dao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.iqmsoft.glassfish4.spring.models.Role;


@Stateless
@EJB(beanInterface = RoleDaoLocal.class, name = "RoleDao", mappedName = "RoleDao")
public class RoleDao implements RoleDaoLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Role getRole(Integer id) {
        return this.em.find(Role.class, id);
    }
}
