
package com.iqmsoft.glassfish4.spring.admin.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityNavigationController {
    
    @RequestMapping(value={"/", "/login"}, method=RequestMethod.GET )
    public String loginForm(Model model) {
        model.addAttribute("message", "Populate Data To Login...");
        return "login";
    } 
     
    @RequestMapping(value="/error-login", method=RequestMethod.GET)
    public String invalidLogin(Model model) {
        model.addAttribute("message", "Wrong Username/Password combination");
        return "login";
    }
     
    @RequestMapping(value="/success-login", method=RequestMethod.GET)
    public String successLogin(Model model, Principal principal) {
        String name = "";
        name = principal.getName(); //get logged in username
        return "redirect:/admin/springmvc/greeting/"+name;
    }
    
    @RequestMapping(value={"/logout"}, method=RequestMethod.GET )
    public String logout(Model model) {
        model.addAttribute("message", "Login...again :)");
        return "login";
    } 
}