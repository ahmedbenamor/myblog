package com.ahmed.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.blog.entity.UserBlog;
import com.ahmed.blog.repository.UserBlogRepository;

@Service
public class UserService {
	@Autowired
	private UserBlogRepository userBlogRepository;
	
	public List<UserBlog> findAll()
	{
		return userBlogRepository.findAll();
	}

}
