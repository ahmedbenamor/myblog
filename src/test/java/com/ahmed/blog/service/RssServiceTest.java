package com.ahmed.blog.service;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ahmed.blog.entity.ItemBlog;
import com.ahmed.blog.exception.RssException;

public class RssServiceTest {

	
	private RssService rssService;
	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
		
	}

	@Test
	public void testGetItemsFile() throws RssException {
	List<ItemBlog> items = rssService.getItems(new File("test-rss/fluxRss.xml"));
	assertEquals(1, items.size());
	for (ItemBlog itemBlog : items) {
		System.out.println("title = "+itemBlog.getTitle());
		System.out.println("description = "+itemBlog.getDescription());
		System.out.println("date pub = "+itemBlog.getPublishDate());
		
	}
	}

}
