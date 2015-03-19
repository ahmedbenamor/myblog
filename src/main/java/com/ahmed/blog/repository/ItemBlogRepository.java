package com.ahmed.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.blog.entity.ItemBlog;

public interface ItemBlogRepository extends JpaRepository<ItemBlog, Long>{
	
	

}
