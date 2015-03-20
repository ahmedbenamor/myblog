package com.ahmed.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmed.blog.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String users(Model model){
		model.addAttribute("users",userService.findAll());
		return "users.pu";
		
	}
	
	@RequestMapping("/{id}")
	public String showUser(@PathVariable String  id, Model model)
	{
		Long idUser = Long.valueOf(id);
		model.addAttribute("user", userService.findUserByIdWithblogs(idUser));
		
		return "user_info.pu";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") String id){
		Long idl = Long.valueOf(id);
		userService.delete(idl);
		
		return "redirect:/users";
	}
	
}
