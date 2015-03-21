package com.ahmed.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmed.blog.service.ItemService;


@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/index")
	public String toIndex(Model model){
		remplirModel(model);
		return "index.pu";
		
	}
	
	

	@RequestMapping("/")
	public String toIndexRacine(Model model){
		remplirModel(model);
		return "index.pu";
		
	}
	
private void remplirModel(Model model) {
	model.addAttribute("items", itemService.getItems());
		
		
	}

}
