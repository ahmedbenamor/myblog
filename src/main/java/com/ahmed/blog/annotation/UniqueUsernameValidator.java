package com.ahmed.blog.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ahmed.blog.repository.UserBlogRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	
	@Autowired
	UserBlogRepository userBlogRepository;
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(userBlogRepository == null)
		{
			return true;
		}
		return userBlogRepository.findByName(username)== null;
	}

}
