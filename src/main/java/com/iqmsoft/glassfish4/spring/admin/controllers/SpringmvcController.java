
package com.iqmsoft.glassfish4.spring.admin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/springmvc")
public class SpringmvcController {
    
    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
       
}
