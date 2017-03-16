
package com.iqmsoft.glassfish4.spring.admin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iqmsoft.glassfish4.spring.services.GreetingServiceInterface;

@Controller
@RequestMapping("/admin/springmvc")
public class SpringmvcController {
    
	
	@Autowired
	protected GreetingServiceInterface gs;
	
    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable String name, Model model) {
    	
        model.addAttribute("name", gs.get(1).getContent() + " " + name);
        return "greeting";
    }
       
}
