package com.iqmsoft.glassfish4.spring.services;

import java.util.List;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.iqmsoft.glassfish4.spring.ejb3.UserDaoLocal;
import com.iqmsoft.glassfish4.spring.models.User;

@Service
@Transactional
public class UserService implements UserServiceInterface{

    @EJB(mappedName = "UserDao")
    private UserDaoLocal userDAO;
 
    public User getUser(String email) {
        User user = new User();
        user.setEmail(email);
        return userDAO.authenticate(user);
    }
    
    public List<User> getAll() {
         return userDAO.getAllUsers("");
    }
    
}
