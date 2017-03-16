package com.iqmsoft.glassfish4.spring.services;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.iqmsoft.glassfish4.spring.ejb3.GreetingDaoLocal;
import com.iqmsoft.glassfish4.spring.models.Greeting;

@Service
@Transactional
public class GreetingService implements GreetingServiceInterface{
    
    @EJB(mappedName = "GreetingDao")
    private GreetingDaoLocal greetDAO;

	@Override
	public Greeting get(long id) {
		return greetDAO.getGreeting(id);
	}
 
   
}

