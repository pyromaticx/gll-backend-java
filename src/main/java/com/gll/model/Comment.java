package com.gll.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentId;
	private String userName;
	private StringBuffer userComment;
	private String timeStamp;

	@ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	private AnnotationModel annotationModel;
	
	public Comment() {
	}


	public int getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public StringBuffer getUserComment() {
		return userComment;
	}


	public void setUserComment(StringBuffer userComment) {
		this.userComment = userComment;
	}


	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
