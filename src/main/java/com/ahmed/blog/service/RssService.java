package com.ahmed.blog.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import com.ahmed.blog.entity.ItemBlog;
import com.ahmed.blog.exception.RssException;
import com.ahmed.blog.rss.ObjectFactory;
import com.ahmed.blog.rss.TRss;
import com.ahmed.blog.rss.TRssChannel;
import com.ahmed.blog.rss.TRssItem;

@Service
public class RssService {

	public List<ItemBlog> getItems(File file) throws RssException {
		return getItems(new StreamSource(file));
	}

	public List<ItemBlog> getItems(String url) throws RssException {
		return getItems(new StreamSource(url));
	}

	private List<ItemBlog> getItems(Source source) throws RssException {
		List<ItemBlog> list = new ArrayList<ItemBlog>();
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source,
					TRss.class);
			TRss rss = jaxbElement.getValue();
			List<TRssChannel> channels = rss.getChannel();
			for (TRssChannel chanel : channels) {
				List<TRssItem> items = chanel.getItem();
				for (TRssItem rssItem : items) {
					ItemBlog item = new ItemBlog();
					item.setTitle(rssItem.getTitle());
					item.setDescription(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					Date pubDate = new SimpleDateFormat(
							"EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
							.parse(rssItem.getPubDate());
					item.setPublishDate(pubDate);
					list.add(item);
				}
			}

		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			throw new RssException(e);
		}
		return list;
	}

}
