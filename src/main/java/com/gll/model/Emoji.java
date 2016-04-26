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
	private String emojiDescription;
	private String emojiCode;
	private String emojiURI;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	public Emoji(int emojiId, String emojiDescription, String emojiCode, String emojiURI, char useStatus,
			String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.emojiId = emojiId;
		this.emojiDescription = emojiDescription;
		this.emojiCode = emojiCode;
		this.emojiURI = emojiURI;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	/*
	 * It will depict who is liking.
	 */
	
	public int getEmojiId() {
		return emojiId;
	}

	public void setEmojiId(int emojiId) {
		this.emojiId = emojiId;
	}

	public String getEmojiDescription() {
		return emojiDescription;
	}

	public void setEmojiDescription(String emojiDescription) {
		this.emojiDescription = emojiDescription;
	}

	public String getEmojiCode() {
		return emojiCode;
	}

	public void setEmojiCode(String emojiCode) {
		this.emojiCode = emojiCode;
	}

	public String getEmojiURI() {
		return emojiURI;
	}

	public void setEmojiURI(String emojiURI) {
		this.emojiURI = emojiURI;
	}

	public char getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(char useStatus) {
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

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Emoji [emojiId=" + emojiId + ", emojiDescription=" + emojiDescription + ", emojiCode=" + emojiCode
				+ ", emojiURI=" + emojiURI + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}

	
	
}
