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
    curl -v -k -X POST -H "Content-Type: application/json" 'https://localhost:8181/SpringMvcGlassFish4/oauth/token?username=kriss@test.com&password=test&client_id=client1&client_secret=client1&grant_type=password'

   
    curl -v -k -X GET -H "Authorization:Bearer b9329283-46b1-4f59-9374-c8cc14e61680"  'https://localhost:8181/SpringMvcGlassFish4/api/springrest/users'
        
        
    curl -v -k -X GET -H "Authorization:Bearer b9329283-46b1-4f59-9374-c8cc14e61680"  "https://localhost:8181/SpringMvcGlassFish4/oauth/logout"
          
     * @return 
     */
    @ResponseBody 
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> findOwner() {
         return userService.getAll();
    }
    
}
