package com.gll.dao;

import java.util.List;
import com.gll.model.AnnotationModel;

public interface AnnotationDao {
	public void save(AnnotationModel annotationModel);
	public List<AnnotationModel> displayAll();
	public AnnotationModel display(int annotationId);
	public void update(AnnotationModel annotationModel);
	public void patch(AnnotationModel annotationModel);
	public void delete(int annotationId);
	public List<AnnotationModel> getAnnotationsByUserName(String userName);
	public List<AnnotationModel> getAnnotationsByDomainName(String domainName);
	public List<AnnotationModel> getAnnotationsByRootDomain(String rootDomain);
	public List<AnnotationModel> getByTopicName(String topicName);
}
