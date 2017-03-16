package com.iqmsoft.glassfish4.spring.services;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.iqmsoft.glassfish4.spring.ejb3.CompanyDaoLocal;
import com.iqmsoft.glassfish4.spring.models.Company;


@Service
@Transactional
public class CompanyService implements CompanyServiceInterface{
    
    @EJB(mappedName = "CompanyDao")
    private CompanyDaoLocal companyDAO;

	@Override
	public Company get(Integer id) {
		return companyDAO.get(id);
	}
 
   
}

