package com.ahmed.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.UserBlog;
import com.ahmed.blog.service.BlogService;
import com.ahmed.blog.service.UserService;

@Controller
@RequestMapping("/signup")
public class RegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("user")
	public UserBlog createUser()
	{
		return new UserBlog();
	}
	
	
	
	
	@RequestMapping
	public String showSignup()
	{
		return "signup.pu";
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String doSignup(@Valid @ModelAttribute("user") UserBlog user, BindingResult result)
	{
		if(result.hasErrors()){
			return "signup.pu";
		}
		
		userService.save(user);
		return "redirect:/signup.pu?success=true";
	}
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username){
		Boolean exist = userService.findByName(username)== null;
		return exist.toString();
	}
}
