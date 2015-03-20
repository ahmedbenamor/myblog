package com.ahmed.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.UserBlog;

public interface BlogRepository extends JpaRepository<Blog, Long>{
	
	List<Blog> findByUser(UserBlog user);

}
