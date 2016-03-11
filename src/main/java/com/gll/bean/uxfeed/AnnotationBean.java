package com.gll.bean.uxfeed;

public class AnnotationBean {

	private int annotationId;
	private int userId;
	private int websiteId;
	private String annotationText;

	public AnnotationBean() {

	}

	public AnnotationBean(int annotationId, int userId, int websiteId, String annotationText) {
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

	public String getAnnotationText() {
		return annotationText;
	}

	public void setAnnotationText(String annotationText) {
		this.annotationText = annotationText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annotationId;
		result = prime * result + ((annotationText == null) ? 0 : annotationText.hashCode());
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
		AnnotationBean other = (AnnotationBean) obj;
		if (annotationId != other.annotationId)
			return false;
		if (annotationText == null) {
			if (other.annotationText != null)
				return false;
		} else if (!annotationText.equals(other.annotationText))
			return false;
		if (userId != other.userId)
			return false;
		if (websiteId != other.websiteId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnnotationBean [annotationId=" + annotationId + ", userId=" + userId + ", websiteId=" + websiteId
				+ ", annotationText=" + annotationText + "]";
	}

}
