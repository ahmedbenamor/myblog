package com.ahmed.blog.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	
	
	@ModelAttribute("blog")
	public Blog createBlog()
	{
		return new Blog();
	}
	
	
	
	
	
	
	@RequestMapping(value="/account", method= RequestMethod.GET)
	public String account(Model model, Principal principal){
		System.out.println("create blog get");
		String name = principal.getName();
		UserBlog user = userService.findUserByNameWithBlogs(name);
		
		model.addAttribute("user", user);
		
		return "account.pu";
		
	}
	
	@RequestMapping(value="/account" , method= RequestMethod.POST)
	public String doCrateBlog(Model model,@Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal)
	{
		System.out.println("create blog");
		if(result.hasErrors())
		{
			System.out.println("has error");
			return account(model, principal);
		}
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account";
		
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable("id") String id){
		Long idl = Long.valueOf(id);
		Blog blog = blogService.findOne(idl);
		blogService.delete(blog);
		return "redirect:/account";
	}
	
	
}
