package com.iqmsoft.glassfish4.spring.services;

import java.util.List;

import com.iqmsoft.glassfish4.spring.models.User;

public interface UserServiceInterface {
    public User getUser(String login);
    
    public List<User> getAll();
}
