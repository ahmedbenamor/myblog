package com.ahmed.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.blog.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{

}
