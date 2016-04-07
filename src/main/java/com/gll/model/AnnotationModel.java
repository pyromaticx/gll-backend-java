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
	private String pinAttribute;
	private int userId;
	private int websiteId;
	private String title;
	private String text;
	private String timeStamp;
	private String type;
	private String pinX;
	private String pinY;
	private String emoji;
	private StringBuilder image;
	private long imageH;
	private long imageW;
	private String comments;
	private boolean isPrivate;
	@Embedded
	private ThumbnailDot thumbnailDot;

	public AnnotationModel() {

	}

	
	public AnnotationModel(int pinId, String pinAttribute, int userId, int websiteId, String title, String text,
			String timeStamp, String type, String pinX, String pinY, String emoji, StringBuilder image, long imageH,
			long imageW, String comments, boolean isPrivate, ThumbnailDot thumbnailDot) {
		super();
		this.pinId = pinId;
		this.pinAttribute = pinAttribute;
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
		this.imageH = imageH;
		this.imageW = imageW;
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


	public String getPinAttribute() {
		return pinAttribute;
	}


	public void setPinAttribute(String pinAttribute) {
		this.pinAttribute = pinAttribute;
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


	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPinX() {
		return pinX;
	}


	public void setPinX(String pinX) {
		this.pinX = pinX;
	}


	public String getPinY() {
		return pinY;
	}


	public void setPinY(String pinY) {
		this.pinY = pinY;
	}


	public String getEmoji() {
		return emoji;
	}


	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}


	public StringBuilder getImage() {
		return image;
	}


	public void setImage(StringBuilder image) {
		this.image = image;
	}


	public long getImageH() {
		return imageH;
	}


	public void setImageH(long imageH) {
		this.imageH = imageH;
	}


	public long getImageW() {
		return imageW;
	}


	public void setImageW(long imageW) {
		this.imageW = imageW;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((emoji == null) ? 0 : emoji.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + (int) (imageH ^ (imageH >>> 32));
		result = prime * result + (int) (imageW ^ (imageW >>> 32));
		result = prime * result + (isPrivate ? 1231 : 1237);
		result = prime * result + ((pinAttribute == null) ? 0 : pinAttribute.hashCode());
		result = prime * result + pinId;
		result = prime * result + ((pinX == null) ? 0 : pinX.hashCode());
		result = prime * result + ((pinY == null) ? 0 : pinY.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((thumbnailDot == null) ? 0 : thumbnailDot.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (imageH != other.imageH)
			return false;
		if (imageW != other.imageW)
			return false;
		if (isPrivate != other.isPrivate)
			return false;
		if (pinAttribute == null) {
			if (other.pinAttribute != null)
				return false;
		} else if (!pinAttribute.equals(other.pinAttribute))
			return false;
		if (pinId != other.pinId)
			return false;
		if (pinX == null) {
			if (other.pinX != null)
				return false;
		} else if (!pinX.equals(other.pinX))
			return false;
		if (pinY == null) {
			if (other.pinY != null)
				return false;
		} else if (!pinY.equals(other.pinY))
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
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
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
