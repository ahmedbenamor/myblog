package com.ahmed.blog.controller;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmed.blog.repository.UserBlogRepository;
import com.ahmed.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users",userService.findAll());
		return "users.pu";
		
	}
	
	@RequestMapping("/users/{id}")
	public String showUser(@PathVariable String  id, Model model)
	{
		Long idUser = Long.valueOf(id);
		model.addAttribute("user", userService.findUserByIdWithblogs(idUser));
		
		return "user_info.pu";
	}
}
