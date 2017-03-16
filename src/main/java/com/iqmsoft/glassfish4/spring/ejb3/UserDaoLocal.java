package com.iqmsoft.glassfish4.spring.ejb3;

import java.util.List;
import javax.ejb.Local;

import com.iqmsoft.glassfish4.spring.models.User;

@Local
public interface UserDaoLocal {

    void addUser(User user);

    void editUser(User user);

    void deleteUser(int id);

    void getUser();

    User getUser(int id);

    List<User> getAllUsers(String search);

    List<User> getAllUsers(String search, int offset, int limit);

    int countAllUsers(String search);

    User getByEmail(String email);
            
    User authenticate(User user);
}
