package com.gll.service.uxfeed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.security.UserDao;
import com.gll.dao.uxfeed.WebsiteDao;
import com.gll.model.security.UserModel;
import com.gll.model.uxfeed.WebsiteModel;

@Service("websiteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class WebsiteServiceImpl implements WebsiteService {

	@Autowired
	private WebsiteDao websiteDao;

	@Override
	public void postWebsite(WebsiteModel websiteModel) {
		websiteDao.postWebsite(websiteModel);
		
	}

	@Override
	public List<WebsiteModel> getAllWebsite() {
		return websiteDao.getAllWebsite();
	}

	@Override
	public WebsiteModel getWebsite(int websiteId) {
		return websiteDao.getWebsite(websiteId);
	}

	@Override
	public void putWebsite(WebsiteModel UserModel) {
		websiteDao.putWebsite(UserModel);
		
	}

	@Override
	public void patchWebsite(WebsiteModel UserModel) {
		websiteDao.patchWebsite(UserModel);
		
	}

	@Override
	public void deleteWebsite(int websiteId) {
		websiteDao.deleteWebsite(websiteId);
		
	}
}
