package com.ahmed.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.blog.entity.UserBlog;

public interface UserBlogRepository extends JpaRepository<UserBlog, Long> {

}
