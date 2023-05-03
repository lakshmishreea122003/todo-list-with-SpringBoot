package com.springProject1.todolistWithSpring.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;

@Controller
@SessionAttributes("name")
public class WelcomeController{


	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		model.put("name", getLoggedIn());
		return "welcome";
	}
	
	private String getLoggedIn() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}