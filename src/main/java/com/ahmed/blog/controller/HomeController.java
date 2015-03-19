package com.ahmed.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String toIndex(){
		
		return "index.pu";
		
	}
	
	@RequestMapping("/")
	public String toIndexRacine(){
		
		return "index.pu";
		
	}

}
