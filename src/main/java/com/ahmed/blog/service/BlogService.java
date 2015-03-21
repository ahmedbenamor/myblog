package com.ahmed.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.ItemBlog;
import com.ahmed.blog.entity.UserBlog;
import com.ahmed.blog.exception.RssException;
import com.ahmed.blog.repository.BlogRepository;
import com.ahmed.blog.repository.ItemBlogRepository;
import com.ahmed.blog.repository.UserBlogRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserBlogRepository userBlogRepository;
	@Autowired
	private ItemBlogRepository itemBlogRepository;
	
	@Autowired
	private RssService rssService;
	
	public void saveItems(Blog blog){
		try {
			List<ItemBlog> items = rssService.getItems(blog.getUrl());
			for (ItemBlog item : items) {
				ItemBlog savedItem = itemBlogRepository.findByBlogAndLink(blog, item.getLink());
				if(savedItem == null){
					item.setBlog(blog);
					itemBlogRepository.save(item);
				}
				
				
			}
		} catch (RssException e) {
			e.printStackTrace();
		}
	}

	public void save(Blog blog, String name) {
		UserBlog user =userBlogRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItems(blog);
		
		
	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
		
	}

	public Blog findOne(Long id) {
		
		return blogRepository.findOne(id);
	}
	
	

}
