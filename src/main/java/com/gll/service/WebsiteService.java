package com.gll.service;

import java.util.List;

import com.gll.model.WebsiteModel;

public interface WebsiteService {
	public void postWebsite(WebsiteModel websiteModel);
	public List<WebsiteModel> getAllWebsite();
	public WebsiteModel getWebsite(int websiteId);
	public void putWebsite(WebsiteModel UserModel);
	public void patchWebsite(WebsiteModel UserModel);
	public void deleteWebsite(int websiteId);
}
