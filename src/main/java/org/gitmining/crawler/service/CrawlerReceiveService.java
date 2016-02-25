package org.gitmining.crawler.service;

import org.springframework.stereotype.Service;

@Service
public class CrawlerReceiveService {
	public void process(String mess){
		System.out.println(mess);
	}
}
