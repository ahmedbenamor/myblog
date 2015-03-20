package com.ahmed.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.ItemBlog;
import com.ahmed.blog.entity.RoleBlog;
import com.ahmed.blog.entity.UserBlog;
import com.ahmed.blog.repository.BlogRepository;
import com.ahmed.blog.repository.ItemBlogRepository;
import com.ahmed.blog.repository.RoleBlogRepository;
import com.ahmed.blog.repository.UserBlogRepository;
@Transactional
@Service
public class InitDataBaseService {
	@Autowired
	private RoleBlogRepository roleBlogRepository;
	@Autowired
	private UserBlogRepository userBlogRepository;
	@Autowired
	private ItemBlogRepository itemBlogRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	@PostConstruct
	public void init()
	{
		RoleBlog role_user = new RoleBlog();
		role_user.setName("ROLE_USER");
		roleBlogRepository.save(role_user);
		
		RoleBlog role_admin = new RoleBlog();
		role_admin.setName("ROLE_ADMIN");
		roleBlogRepository.save(role_admin);
		
		
		UserBlog admin = new UserBlog();
		admin.setName("admin");
		admin.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		admin.setPassword(encoder.encode("admin"));
		List<RoleBlog> roles = new ArrayList<RoleBlog>();
		roles.add(role_admin);
		roles.add(role_user);
		admin.setRoles(roles);
		userBlogRepository.save(admin);
		
		Blog blogJava = new Blog();
		blogJava.setName("java");
		blogJava.setUrl("http://www.ahmedbenamor.com/myblog");
		blogJava.setUser(admin);
		blogRepository.save(blogJava);
		
		
		ItemBlog item1 = new ItemBlog();
		item1.setBlog(blogJava);
		item1.setTitle("websocket");
		item1.setLink("http://ahmedbenamor.com/JMS-WEBSOCKET");
		item1.setPublishDate(new Date());
		itemBlogRepository.save(item1);
		
		ItemBlog item2 = new ItemBlog();
		item2.setBlog(blogJava);
		item2.setTitle("reachness");
		item2.setLink("http://ahmedbenamor.com/reachness");
		item2.setPublishDate(new Date());
		itemBlogRepository.save(item2);
		
	}

}
