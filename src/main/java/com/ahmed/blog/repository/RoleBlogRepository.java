package com.ahmed.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.blog.entity.RoleBlog;

public interface RoleBlogRepository extends JpaRepository<RoleBlog, Long> {
	

}
