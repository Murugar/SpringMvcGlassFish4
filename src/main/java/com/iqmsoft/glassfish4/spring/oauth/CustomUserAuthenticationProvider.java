
package com.iqmsoft.glassfish4.spring.oauth;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.iqmsoft.glassfish4.spring.dao.UserDaoLocal;
import com.iqmsoft.glassfish4.spring.models.User;

public class CustomUserAuthenticationProvider implements AuthenticationProvider {
    
    private static final Logger LOGGER = Logger.getLogger("CustomUserAuthenticationProvider");
    
    @EJB(mappedName = "UserDao")
    @Autowired
    private UserDaoLocal userDAO;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        LOGGER.warning("!!!Authenticate: "+authentication.getPrincipal().toString()+":"+authentication.getCredentials().toString());
        
        if (!supports(authentication.getClass())) {
            return null;
        }
        if (authentication.getCredentials() == null) {
            LOGGER.warning("No credentials found in request.");
            boolean throwExceptionWhenTokenRejected = false;
            if (throwExceptionWhenTokenRejected) {
                throw new BadCredentialsException("No pre-authenticated credentials found in request.");
            }
            return null;
        }
        
        User user = userDAO.getByEmail(authentication.getPrincipal().toString());
        
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        if(!enc.matches(authentication.getCredentials().toString(), user.getPassword())){
            throw new BadCredentialsException("Bad User Credentials.");
        }
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        CustomUserPasswordAuthenticationToken auth = new CustomUserPasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), grantedAuthorities);

        return auth;
        
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {

        return true;
    }

}
