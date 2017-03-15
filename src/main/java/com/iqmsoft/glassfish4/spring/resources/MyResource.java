
package com.iqmsoft.glassfish4.spring.resources;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
@Component 
public class MyResource {

	@RequestMapping(value="/info", method = RequestMethod.GET, produces = "application/json")
	public String createInfo(){
		return "\n\n\t!!!Protected Resource(createInfo) Accessed !!!! Returning from Myresource createInfo\n";

	}

	@RequestMapping(value="/getMyInfo",method = RequestMethod.GET, produces = "application/json")
	public String getMyInfo(){
		
		return "\n\n\t Protected Resource(getMyInfo) Accessed !!!! Returning from Myresource getMyInfo\n";
	}

	@RequestMapping(value="/updateInfo",method = RequestMethod.GET, produces = "application/json")
	public String updateMyInfo(){
		return "\n\n\t Protected Resource(updateInfo) Accessed !!!! Returning from Myresource updateInfo\n";
		
	}

}
