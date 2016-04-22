package com.gll.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AnnotationModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int annotationId;
	
	@ElementCollection()
	@JoinTable(name = "Comment", joinColumns = { @JoinColumn(name = "annotationId") })
	private Collection<Comment> comments = new ArrayList<Comment>();
	
	@OneToMany
	private Emoji emoji;
	
	@OneToMany
	private FlaggedAnnotation flaggedAnnotation;
	
	@Embedded
	private ThumbnailDot thumbnailDot;
	
	@OneToMany
	private UserPin pinAttribute;
	
	@OneToMany
	private Vote vote;

	@ManyToOne
	private WebsiteModel domain;

	// Foreign Key
	private int userId;
	
	private String title; //
	private String text; //
	private long timeStamp; //
	
	/* what type of annotation is ? audo or video or text ?
	 * */
	private String type;
	private String pinX;
	private String pinY; 
	private StringBuffer userImage;
	private StringBuffer image;
	private long imageH;//
	private long imageW;//
	
	/*
	 * Whether the annotation is private or public. It is boolean. true means annotation is private.*/
	private boolean privateStatus;
	

	public AnnotationModel() {

	}

	
}
