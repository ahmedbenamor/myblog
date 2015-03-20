package com.ahmed.blog.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Blog {
	@Id
	@GeneratedValue
	private Long id;
	
	private String url;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserBlog user;
	
	@OneToMany(mappedBy="blog", cascade=CascadeType.REMOVE)
	private List<ItemBlog> items;

	public List<ItemBlog> getItems() {
		return items;
	}

	public void setItems(List<ItemBlog> items) {
		this.items = items;
	}

	public UserBlog getUser() {
		return user;
	}

	public void setUser(UserBlog user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
