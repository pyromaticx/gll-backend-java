package com.gll.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnnotationModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pinId;
	private int userId;
	private int websiteId;
	private String title;
	private String text;
	private int timeStamp;
	private String type;
	private int pinX;
	private int pinY;
	private String emoji;
	private int image;
	private String comments;
	private boolean isPrivate;
	@Embedded
	private ThumbnailDot thumbnailDot;

	public AnnotationModel() {

	}

	public AnnotationModel(int pinId, int userId, int websiteId, String title, String text, int timeStamp, String type,
			int pinX, int pinY, String emoji, int image, String comments, boolean isPrivate,
			ThumbnailDot thumbnailDot) {
		super();
		this.pinId = pinId;
		this.userId = userId;
		this.websiteId = websiteId;
		this.title = title;
		this.text = text;
		this.timeStamp = timeStamp;
		this.type = type;
		this.pinX = pinX;
		this.pinY = pinY;
		this.emoji = emoji;
		this.image = image;
		this.comments = comments;
		this.isPrivate = isPrivate;
		this.thumbnailDot = thumbnailDot;
	}

	public int getPinId() {
		return pinId;
	}

	public void setPinId(int pinId) {
		this.pinId = pinId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPinX() {
		return pinX;
	}

	public void setPinX(int pinX) {
		this.pinX = pinX;
	}

	public int getPinY() {
		return pinY;
	}

	public void setPinY(int pinY) {
		this.pinY = pinY;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public ThumbnailDot getThumbnailDot() {
		return thumbnailDot;
	}

	public void setThumbnailDot(ThumbnailDot thumbnailDot) {
		this.thumbnailDot = thumbnailDot;
	}

	@Override
	public String toString() {
		return "AnnotationModel [pinId=" + pinId + ", userId=" + userId + ", websiteId=" + websiteId + ", title="
				+ title + ", text=" + text + ", timeStamp=" + timeStamp + ", type=" + type + ", pinX=" + pinX
				+ ", pinY=" + pinY + ", emoji=" + emoji + ", image=" + image + ", comments=" + comments + ", isPrivate="
				+ isPrivate + ", thumbnailDot=" + thumbnailDot + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((emoji == null) ? 0 : emoji.hashCode());
		result = prime * result + image;
		result = prime * result + (isPrivate ? 1231 : 1237);
		result = prime * result + pinId;
		result = prime * result + pinX;
		result = prime * result + pinY;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((thumbnailDot == null) ? 0 : thumbnailDot.hashCode());
		result = prime * result + timeStamp;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (emoji == null) {
			if (other.emoji != null)
				return false;
		} else if (!emoji.equals(other.emoji))
			return false;
		if (image != other.image)
			return false;
		if (isPrivate != other.isPrivate)
			return false;
		if (pinId != other.pinId)
			return false;
		if (pinX != other.pinX)
			return false;
		if (pinY != other.pinY)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (thumbnailDot == null) {
			if (other.thumbnailDot != null)
				return false;
		} else if (!thumbnailDot.equals(other.thumbnailDot))
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId != other.userId)
			return false;
		if (websiteId != other.websiteId)
			return false;
		return true;
	}

}
