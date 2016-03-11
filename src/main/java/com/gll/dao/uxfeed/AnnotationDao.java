package com.gll.dao.uxfeed;

import java.util.List;

import com.gll.model.uxfeed.AnnotationModel;

public interface AnnotationDao {
	public void save(AnnotationModel annotationModel);
	public List<AnnotationModel> displayAll();
	public AnnotationModel display(int annotationId);
	public void update(AnnotationModel annotationModel);
	public void patch(AnnotationModel annotationModel);
	public void delete(int annotationId);
}
