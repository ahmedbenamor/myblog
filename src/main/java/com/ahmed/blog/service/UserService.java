package com.ahmed.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.ItemBlog;
import com.ahmed.blog.entity.UserBlog;
import com.ahmed.blog.repository.BlogRepository;
import com.ahmed.blog.repository.ItemBlogRepository;
import com.ahmed.blog.repository.UserBlogRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserBlogRepository userBlogRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemBlogRepository itemBlogRepository;
	
	public List<UserBlog> findAll()
	{
		return userBlogRepository.findAll();
	}

	public UserBlog findUserById(Long idUser) {
		return userBlogRepository.findOne(idUser);
	}

	@Transactional
	public UserBlog findUserByIdWithblogs(Long idUser) {
		UserBlog user = findUserById(idUser);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog: blogs) {
			List<ItemBlog> items = itemBlogRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishDate"));
			blog.setItems(items);
			
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(UserBlog user) {
		userBlogRepository.save(user);
		
	}

}
