package com.ahmed.blog.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.ahmed.blog.annotation.UniqueUsername;


@Entity
public class UserBlog {
	
	@Id
	@GeneratedValue
	private Long id;
	@Size(min=3, message="Name must be at least 3 characters")
	@Column(unique=true)
	@UniqueUsername(message="usearname already exist")
	private String name;
	@Size(min=1, message="Invalid email address")
	@Email(message="Invalid email address")
	private String email;
	@Size(min=5, message="Password must be at least 5 characters")
	private String password;
	private Boolean enabled;
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@ManyToMany
	@JoinTable
	private List<RoleBlog> roles;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
	private List<Blog> blogs;
	
	

	public List<RoleBlog> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBlog> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
