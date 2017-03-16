package com.iqmsoft.glassfish4.spring.ejb3;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.iqmsoft.glassfish4.spring.models.Company;



@Stateless
@EJB(beanInterface = CompanyDaoLocal.class, name = "CompanyDao", mappedName = "CompanyDao")
public class CompanyDao implements CompanyDaoLocal{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Company get(Integer id) {
		return this.em.find(Company.class, id);
	}

	
}
