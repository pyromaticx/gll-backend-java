package com.gll.model.uxfeed;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AnnotationModel {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int annotationId;
	private int userId;
	private int websiteId;
	private int annotationText;

	public AnnotationModel() {

	}

	public AnnotationModel(int annotationId, int userId, int websiteId, int annotationText) {
		super();
		this.annotationId = annotationId;
		this.userId = userId;
		this.websiteId = websiteId;
		this.annotationText = annotationText;
	}

	public int getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public int getAnnotationText() {
		return annotationText;
	}

	public void setAnnotationText(int annotationText) {
		this.annotationText = annotationText;
	}

	@Override
	public String toString() {
		return "AnnotationBean [annotationId=" + annotationId + ", userId=" + userId + ", websiteId=" + websiteId
				+ ", annotationText=" + annotationText + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annotationId;
		result = prime * result + annotationText;
		result = prime * result + userId;
		result = prime * result + websiteId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnotationModel other = (AnnotationModel) obj;
		if (annotationId != other.annotationId)
			return false;
		if (annotationText != other.annotationText)
			return false;
		if (userId != other.userId)
			return false;
		if (websiteId != other.websiteId)
			return false;
		return true;
	}


}
