package com.ahmed.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.blog.entity.Blog;
import com.ahmed.blog.entity.ItemBlog;

public interface ItemBlogRepository extends JpaRepository<ItemBlog, Long>{
	
	List<ItemBlog> findByBlog(Blog blog);

}
