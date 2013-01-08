package com.vv.bioworld.core.controllers;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController implements ServletContextAware {

	ServletContext context;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}

	@RequestMapping(value = "/")
	public String home() {
		System.out.println("HomeController: Passing through...");
//		System.out.println("Context path " + context.g);
//		System.out.println("Real path " + context.getRealPath("/"));
		return "index";
	}
	
	@RequestMapping(value = "/register")
	public String register() {
		System.out.println("HomeController: Registering...");
		return "register";
	}
	
	@RequestMapping(value = "/post")
	public String post(ModelAndView d) {
		System.out.println("HomeController: Received content...");
		return "register";
	}
	
	@RequestMapping(value = "/css")
	public String css() {
		System.out.println("HomeController: Received content...");
		return "resources/css/style.css";
	}
	
	
}
