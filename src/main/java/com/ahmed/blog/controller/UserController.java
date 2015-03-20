package com.ahmed.blog.controller;

import java.security.Principal;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.CppCodeGenerator;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.UserBlog;
import com.ahmed.blog.repository.UserBlogRepository;
import com.ahmed.blog.service.BlogService;
import com.ahmed.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("user")
	public UserBlog createUser()
	{
		return new UserBlog();
	}
	
	@ModelAttribute("blog")
	public Blog createBlog()
	{
		return new Blog();
	}
	
	
	
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
	
	@RequestMapping("signup")
	public String showSignup()
	{
		return "signup.pu";
	}
	
	@RequestMapping(value="signup" , method= RequestMethod.POST)
	public String doSignup(@ModelAttribute("user") UserBlog user)
	{
		
		userService.save(user);
		return "redirect:/signup.pu?success=true";
	}
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String name = principal.getName();
		UserBlog user = userService.findUserByNameWithBlogs(name);
		
		model.addAttribute("user", user);
		
		return "user_info.pu";
		
	}
	
	@RequestMapping(value="account" , method= RequestMethod.POST)
	public String doCrateBlog(@ModelAttribute("blog") Blog blog, Principal principal)
	{
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account";
		
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable("id") String id){
		Long idl = Long.valueOf(id);
		blogService.delete(idl);
		return "redirect:/account";
	}
	@RequestMapping("/user/remove/{id}")
	public String removeUser(@PathVariable("id") String id){
		Long idl = Long.valueOf(id);
		userService.delete(idl);
		
		return "redirect:/users";
	}
	
}
