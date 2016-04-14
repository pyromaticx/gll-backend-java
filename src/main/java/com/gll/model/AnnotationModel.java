package com.gll.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class AnnotationModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pinId;
	private String pinAttribute;//
	private int userId; //
	private int websiteId; //
	private String title; //
	private String text; //
	private long timeStamp; //
	private String type;//
	private String pinX; //
	private String pinY; //
	private String emoji; //
	private StringBuffer userImage; //
	private StringBuffer image; //
	private String rootDomain; //
	private String domainName; //
	private long imageH;//
	private long imageW;//
	
	@OneToMany(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinTable(name = "AnnotationModel_Comment", joinColumns = { @JoinColumn(name = "pinId") }, inverseJoinColumns = { @JoinColumn(name = "commentId") })
	private Set<Comment> comments;

	private boolean privateStatus; //
	@Embedded
	private ThumbnailDot thumbnailDot;

	public AnnotationModel() {

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

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
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

	public StringBuffer getUserImage() {
		return userImage;
	}

	public void setUserImage(StringBuffer userImage) {
		this.userImage = userImage;
	}

	public StringBuffer getImage() {
		return image;
	}

	public void setImage(StringBuffer image) {
		this.image = image;
	}

	public String getRootDomain() {
		return rootDomain;
	}

	public void setRootDomain(String rootDomain) {
		this.rootDomain = rootDomain;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public boolean isPrivateStatus() {
		return privateStatus;
	}

	public void setPrivateStatus(boolean privateStatus) {
		this.privateStatus = privateStatus;
	}

	public ThumbnailDot getThumbnailDot() {
		return thumbnailDot;
	}

	public void setThumbnailDot(ThumbnailDot thumbnailDot) {
		this.thumbnailDot = thumbnailDot;
	}

}
