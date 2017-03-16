package com.iqmsoft.glassfish4.spring.ejb3;

import javax.ejb.Local;

import com.iqmsoft.glassfish4.spring.models.Company;



@Local
public interface CompanyDaoLocal {
	 Company get(Integer id);
}

