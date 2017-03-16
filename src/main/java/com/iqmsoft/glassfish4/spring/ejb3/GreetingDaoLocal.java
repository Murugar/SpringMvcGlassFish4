package com.iqmsoft.glassfish4.spring.ejb3;

import javax.ejb.Local;

import com.iqmsoft.glassfish4.spring.models.Greeting;

@Local
public interface GreetingDaoLocal {
	 Greeting getGreeting(long id);
}
