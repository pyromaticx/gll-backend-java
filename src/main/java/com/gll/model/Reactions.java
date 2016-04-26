package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reactions {
	private int reactionId;
	private int reactionTypeId;
	private int annotationId;
	private String reactionValue;
	private int reactionBy;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	public int getReactionId() {
		return reactionId;
	}
	public void setReactionId(int reactionId) {
		this.reactionId = reactionId;
	}
	public int getReactionTypeId() {
		return reactionTypeId;
	}
	public void setReactionTypeId(int reactionTypeId) {
		this.reactionTypeId = reactionTypeId;
	}
	public int getAnnotationId() {
		return annotationId;
	}
	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}
	public String getReactionValue() {
		return reactionValue;
	}
	public void setReactionValue(String reactionValue) {
		this.reactionValue = reactionValue;
	}
	public int getReactionBy() {
		return reactionBy;
	}
	public void setReactionBy(int reactionBy) {
		this.reactionBy = reactionBy;
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
}