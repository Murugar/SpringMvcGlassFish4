package com.iqmsoft.glassfish4.spring.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.glassfish4.spring.models.Greeting;
import com.iqmsoft.glassfish4.spring.models.User;
import com.iqmsoft.glassfish4.spring.services.UserServiceInterface;


// rest example

@RestController
@RequestMapping("/springrest")
@Component 
public class SpringrestController{
    
    @Autowired
    protected UserServiceInterface userService;
    
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET, produces = "application/json")
    public Greeting findOwner(@PathVariable Long id) {
         return new Greeting(id, "This is Greeting");
    }
    
    /**
     * curl -v -X POST -H "Content-Type: application/json" 'https://localhost:8181/springmvcrest/oauth/token?username=kriss@test.com&password=test&client_id=client1&client_secret=client1&grant_type=password'

        {
                "access_token":"89fda693-ec29-451b-8be0-2b71c7f11999",
                "token_type":"bearer",
                "refresh_token":"2b86f070-ed56-41f4-8d13-faddc104b1bd",
                "expires_in":299880,
                "scope":"client1"
        }


       curl -v -X GET -H "Authorization:Bearer 03094071-76d8-4e30-a13e-a34f1074e851"  'https://localhost:8181/springmvcrest/api/springrest/users'
        
       curl -v -X POST -H "Content-Type: application/json" 'https://localhost:8181/springmvcrest/oauth/token?username=kriss@test.com&password=test&client_id=client1&client_secret=client1&grant_type=refresh_token&refresh_token=2b86f070-ed56-41f4-8d13-faddc104b1bd'
        
       curl -v -X GET -H "Authorization:Bearer 89fda693-ec29-451b-8be0-2b71c7f11999"  "https://localhost:8181/springmvcrest/oauth/logout"
       
     * @return 
     */
    @ResponseBody 
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> findOwner() {
         return userService.getAll();
    }
    
}
