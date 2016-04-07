package com.gll.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gll.domain.WebsiteModel;

public interface WebsiteService extends PagingAndSortingRepository<WebsiteModel, Long> {

	@Query(value="from WebsiteModel where domainName = ?")
	public WebsiteModel findByDomainName(String domainName);
}
