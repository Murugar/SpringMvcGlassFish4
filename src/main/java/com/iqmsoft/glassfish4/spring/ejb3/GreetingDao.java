package com.iqmsoft.glassfish4.spring.ejb3;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.iqmsoft.glassfish4.spring.models.Greeting;


@Stateless
@EJB(beanInterface = GreetingDaoLocal.class, name = "GreetingDao", mappedName = "GreetingDao")
public class GreetingDao implements GreetingDaoLocal{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Greeting getGreeting(long id) {
		return this.em.find(Greeting.class, id);
	}

	
}
