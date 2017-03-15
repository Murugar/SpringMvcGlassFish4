
package com.iqmsoft.glassfish4.spring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iqmsoft.glassfish4.spring.dao.BackendUserDaoLocal;
import com.iqmsoft.glassfish4.spring.models.BackendUser;

@Service("customUserDetailsService")
@Transactional
@Configurable
public class CustomUserDetailsService implements UserDetailsService{
    
    @EJB(mappedName = "BackendUserDao")
    @Autowired
    private BackendUserDaoLocal userDAO;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        BackendUser domainUser = userDAO.getByUsername(username);
         
        
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Integer access = 1;
        
        org.springframework.security.core.userdetails.User sessUser =  new org.springframework.security.core.userdetails.User(
                domainUser.getUsername(),
                domainUser.getPassword(),
                domainUser.isEnabled(),
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(access)
        );
       
        return sessUser;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities(Integer access) {
//        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(access));
//        return authList;
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        if (access.compareTo(1) == 0) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else{
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authList;
    }
     
    public List<String> getRoles(Integer role) {
 
        List<String> roles = new ArrayList<String>();
 
        if (role.intValue() == 1) {
            roles.add("ROLE_ADMINISTRATOR");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_USER");
        }
        return roles;
    }
     
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
