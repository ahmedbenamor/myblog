package com.ahmed.blog.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RoleBlog {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<UserBlog> users;
	
	public List<UserBlog> getUsers() {
		return users;
	}
	public void setUsers(List<UserBlog> users) {
		this.users = users;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
