
package com.iqmsoft.glassfish4.spring.admin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iqmsoft.glassfish4.spring.services.CompanyServiceInterface;
import com.iqmsoft.glassfish4.spring.services.GreetingServiceInterface;

@Controller
@RequestMapping("/admin/springmvc")
public class SpringmvcController {
    
	
	@Autowired
	protected GreetingServiceInterface gs;
	
	@Autowired
	protected CompanyServiceInterface cs;
	
    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable String name, Model model) {
    	
    	model.addAttribute("company", cs.get(1).getName());
        model.addAttribute("name", gs.get(1).getContent() + " " + name);
        return "greeting";
    }
       
}
