
package com.iqmsoft.glassfish4.spring.ejb3;

import javax.ejb.Local;

import com.iqmsoft.glassfish4.spring.models.BackendUser;


@Local
public interface BackendUserDaoLocal {
    void addBackendUser(BackendUser user);
    void editBackendUser(BackendUser user);
    void deleteBackendUser(int id);
    BackendUser getBackendUser(int id);
    BackendUser getByUsername(String username);
}
