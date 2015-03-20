package com.ahmed.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.UserBlog;
import com.ahmed.blog.repository.BlogRepository;
import com.ahmed.blog.repository.UserBlogRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserBlogRepository userBlogRepository;

	public void save(Blog blog, String name) {
		UserBlog user =userBlogRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
		
	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
		
	}

	public Blog findOne(Long id) {
		
		return blogRepository.findOne(id);
	}
	
	

}
