package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author umesh
 *
 */
@Entity
public class Emoji {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emojiId;

	/*
	 * With the help of annotationId property you can know that annotation is
	 * liked!
	 */
	@ManyToOne
	private int annotationId;

	private String emojiDescription;
	private StringBuffer emojiPic;
	private Boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	/*
	 * It will depict who is liking.
	 */
	@OneToMany
	private int userId;
	
	public int getEmojiId() {
		return emojiId;
	}
	public void setEmojiId(int emojiId) {
		this.emojiId = emojiId;
	}
	public int getAnnotationId() {
		return annotationId;
	}
	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}
	public String getEmojiDescription() {
		return emojiDescription;
	}
	public void setEmojiDescription(String emojiDescription) {
		this.emojiDescription = emojiDescription;
	}
	public StringBuffer getEmojiPic() {
		return emojiPic;
	}
	public void setEmojiPic(StringBuffer emojiPic) {
		this.emojiPic = emojiPic;
	}
	public Boolean getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(Boolean useStatus) {
		this.useStatus = useStatus;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getLocId() {
		return LocId;
	}
	public void setLocId(String locId) {
		LocId = locId;
	}
	public Date getTimeUpdated() {
		return timeUpdated;
	}
	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Emoji [emojiId=" + emojiId + ", annotationId=" + annotationId + ", emojiDescription=" + emojiDescription
				+ ", emojiPic=" + emojiPic + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", userId=" + userId + "]";
	}

	
}
