package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ReactionType {
	private int reactionTypeId;
	private int reactionTypeDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private date timeUpdated;
	private int updatedBy;
	public int getReactionTypeId() {
		return reactionTypeId;
	}
	public void setReactionTypeId(int reactionTypeId) {
		this.reactionTypeId = reactionTypeId;
	}
	public int getReactionTypeDescription() {
		return reactionTypeDescription;
	}
	public void setReactionTypeDescription(int reactionTypeDescription) {
		this.reactionTypeDescription = reactionTypeDescription;
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
	public date getTimeUpdated() {
		return dateTime;
	}
	public void setTimeUpdated(date dateTime) {
		this.dateTime = dateTime;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}