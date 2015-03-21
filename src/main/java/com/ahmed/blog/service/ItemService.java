package com.ahmed.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ahmed.blog.entity.ItemBlog;
import com.ahmed.blog.repository.ItemBlogRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemBlogRepository itemBlogRepository;
	
	public List<ItemBlog> getItems(){
		return itemBlogRepository.findAll(new PageRequest(0, 20, Direction.DESC, "publishDate")).getContent();
	}

}
