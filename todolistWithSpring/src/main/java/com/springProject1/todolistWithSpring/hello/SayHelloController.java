package com.springProject1.todolistWithSpring.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		System.out.println(name);
		return "sayHello";
	}
	
	
	//, ModelMap model
	//@RequestParam String name
	
	//JSP
	
}
