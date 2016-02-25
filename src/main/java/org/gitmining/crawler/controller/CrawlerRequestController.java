package org.gitmining.crawler.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitmining.crawler.service.CrawlerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawler")
public class CrawlerRequestController {
	@Autowired
	private CrawlerRequestService crawlerRequestService;
	public void setCrawlerRequestService(CrawlerRequestService crawlerRequestService) {
		this.crawlerRequestService = crawlerRequestService;
	}

	@RequestMapping(value = "/{owner}/{reponame}")
	public String getCrawlingRepo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		crawlerRequestService.sendRequest(owner+"/"+reponame);
		return "Success";
	}
}
