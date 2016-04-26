package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Annotation {

	@Id
	private int annotationId;
	private String annotationTitle;
	private String annotationText;
	private StringBuffer annotationScreenshot;
	private int annotationScreenshotHeight;
	private int annotationScreenshotWidth;
	private String annotationScreenshotPinXCoordinate;
	private String annotationScreenshotPinYCoordinate;
	private String annotationAudioURL;
	private String annotationAttachmentURL;
	@OneToOne
	private int emojiId;
	
	@OneToMany
	private int pinId;
	private int pinTypeId;
	private int annotationContentTypeId;
	private int pinContentId;
	private int annotationTypeId;
	private int annotationHashtagId;
	private int parentDomainId;
	private long specificURL;
	private String pinXCoordinate;
	private String pinYCoordinate;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	
	public Annotation() {
		
	}


	
	public Annotation(int annotationId, String annotationTitle, String annotationDescription,
			StringBuffer annotationMedia, StringBuffer annotationScreenshot, int annotationScreenshotHeight,
			int annotationScreenshotWidth, String annotationScreenshotPinXCoordinate,
			String annotationScreenshotPinYCoordinate, int emojiId, int pinId, int pinContentId, int annotationTypeId,
			int annotationHashtagId, int parentURLId, int specificURL, String pinXCoordinate, String pinYCoordinate,
			char useStatus, String programId, String locId, Date timeUpdated, int userId) {
		super();
		this.annotationId = annotationId;
		this.annotationTitle = annotationTitle;
		this.annotationScreenshot = annotationScreenshot;
		this.annotationScreenshotHeight = annotationScreenshotHeight;
		this.annotationScreenshotWidth = annotationScreenshotWidth;
		this.annotationScreenshotPinXCoordinate = annotationScreenshotPinXCoordinate;
		this.annotationScreenshotPinYCoordinate = annotationScreenshotPinYCoordinate;
		this.emojiId = emojiId;
		this.pinId = pinId;
		this.pinContentId = pinContentId;
		this.annotationTypeId = annotationTypeId;
		this.annotationHashtagId = annotationHashtagId;
		this.parentDomainId = parentURLId;
		this.specificURL = specificURL;
		this.pinXCoordinate = pinXCoordinate;
		this.pinYCoordinate = pinYCoordinate;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}



	public int getAnnotationId() {
		return annotationId;
	}


	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}


	public String getAnnotationTitle() {
		return annotationTitle;
	}


	public void setAnnotationTitle(String annotationTitle) {
		this.annotationTitle = annotationTitle;
	}


	public StringBuffer getAnnotationScreenshot() {
		return annotationScreenshot;
	}


	public void setAnnotationScreenshot(StringBuffer annotationScreenshot) {
		this.annotationScreenshot = annotationScreenshot;
	}


	public int getAnnotationScreenshotHeight() {
		return annotationScreenshotHeight;
	}


	public void setAnnotationScreenshotHeight(int annotationScreenshotHeight) {
		this.annotationScreenshotHeight = annotationScreenshotHeight;
	}


	public int getAnnotationScreenshotWidth() {
		return annotationScreenshotWidth;
	}


	public void setAnnotationScreenshotWidth(int annotationScreenshotWidth) {
		this.annotationScreenshotWidth = annotationScreenshotWidth;
	}


	public String getAnnotationScreenshotPinXCoordinate() {
		return annotationScreenshotPinXCoordinate;
	}


	public void setAnnotationScreenshotPinXCoordinate(String annotationScreenshotPinXCoordinate) {
		this.annotationScreenshotPinXCoordinate = annotationScreenshotPinXCoordinate;
	}


	public String getAnnotationScreenshotPinYCoordinate() {
		return annotationScreenshotPinYCoordinate;
	}


	public void setAnnotationScreenshotPinYCoordinate(String annotationScreenshotPinYCoordinate) {
		this.annotationScreenshotPinYCoordinate = annotationScreenshotPinYCoordinate;
	}


	public int getEmojiId() {
		return emojiId;
	}


	public void setEmojiId(int emojiId) {
		this.emojiId = emojiId;
	}


	public int getPinId() {
		return pinId;
	}


	public void setPinId(int pinId) {
		this.pinId = pinId;
	}


	public int getPinContentId() {
		return pinContentId;
	}


	public void setPinContentId(int pinContentId) {
		this.pinContentId = pinContentId;
	}


	public int getAnnotationTypeId() {
		return annotationTypeId;
	}


	public void setAnnotationTypeId(int annotationTypeId) {
		this.annotationTypeId = annotationTypeId;
	}


	public int getAnnotationHashtagId() {
		return annotationHashtagId;
	}


	public void setAnnotationHashtagId(int annotationHashtagId) {
		this.annotationHashtagId = annotationHashtagId;
	}


	public int getParentDomainId() {
		return parentDomainId;
	}


	public void setParentDomainId(int parentURLId) {
		this.parentDomainId = parentURLId;
	}


	public long getSpecificURL() {
		return specificURL;
	}


	public void setSpecificURL(int specificURL) {
		this.specificURL = specificURL;
	}


	public String getPinXCoordinate() {
		return pinXCoordinate;
	}


	public void setPinXCoordinate(String pinXCoordinate) {
		this.pinXCoordinate = pinXCoordinate;
	}


	public String getPinYCoordinate() {
		return pinYCoordinate;
	}


	public void setPinYCoordinate(String pinYCoordinate) {
		this.pinYCoordinate = pinYCoordinate;
	}


	public char isUseStatus() {
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


	public int getUserId() {
		return updatedBy;
	}


	public void setUserId(int userId) {
		this.updatedBy = userId;
	}


	public String getAnnotationText() {
		return annotationText;
	}



	public void setAnnotationText(String annotationText) {
		this.annotationText = annotationText;
	}



	public String getAnnotationAudioURL() {
		return annotationAudioURL;
	}



	public void setAnnotationAudioURL(String annotationAudioURL) {
		this.annotationAudioURL = annotationAudioURL;
	}



	public String getAnnotationAttachmentURL() {
		return annotationAttachmentURL;
	}



	public void setAnnotationAttachmentURL(String annotationAttachmentURL) {
		this.annotationAttachmentURL = annotationAttachmentURL;
	}



	public int getPinTypeId() {
		return pinTypeId;
	}



	public void setPinTypeId(int pinTypeId) {
		this.pinTypeId = pinTypeId;
	}



	public int getAnnotationContentTypeId() {
		return annotationContentTypeId;
	}



	public void setAnnotationContentTypeId(int annotationContentTypeId) {
		this.annotationContentTypeId = annotationContentTypeId;
	}



	public int getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}



	public char getUseStatus() {
		return useStatus;
	}



	public void setSpecificURL(long specificURL) {
		this.specificURL = specificURL;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + annotationHashtagId;
		result = prime * result + annotationId;
		result = prime * result + ((annotationScreenshot == null) ? 0 : annotationScreenshot.hashCode());
		result = prime * result + annotationScreenshotHeight;
		result = prime * result
				+ ((annotationScreenshotPinXCoordinate == null) ? 0 : annotationScreenshotPinXCoordinate.hashCode());
		result = prime * result
				+ ((annotationScreenshotPinYCoordinate == null) ? 0 : annotationScreenshotPinYCoordinate.hashCode());
		result = prime * result + annotationScreenshotWidth;
		result = prime * result + ((annotationTitle == null) ? 0 : annotationTitle.hashCode());
		result = prime * result + annotationTypeId;
		result = prime * result + emojiId;
		result = prime * result + parentDomainId;
		result = prime * result + pinContentId;
		result = prime * result + pinId;
		result = prime * result + ((pinXCoordinate == null) ? 0 : pinXCoordinate.hashCode());
		result = prime * result + ((pinYCoordinate == null) ? 0 : pinYCoordinate.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + specificURL;
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (useStatus ? 1231 : 1237);
		result = prime * result + updatedBy;
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
		Annotation other = (Annotation) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationDescription == null) {
			if (other.annotationDescription != null)
				return false;
		} else if (!annotationDescription.equals(other.annotationDescription))
			return false;
		if (annotationHashtagId != other.annotationHashtagId)
			return false;
		if (annotationId != other.annotationId)
			return false;
		if (annotationMedia == null) {
			if (other.annotationMedia != null)
				return false;
		} else if (!annotationMedia.equals(other.annotationMedia))
			return false;
		if (annotationScreenshot == null) {
			if (other.annotationScreenshot != null)
				return false;
		} else if (!annotationScreenshot.equals(other.annotationScreenshot))
			return false;
		if (annotationScreenshotHeight != other.annotationScreenshotHeight)
			return false;
		if (annotationScreenshotPinXCoordinate == null) {
			if (other.annotationScreenshotPinXCoordinate != null)
				return false;
		} else if (!annotationScreenshotPinXCoordinate.equals(other.annotationScreenshotPinXCoordinate))
			return false;
		if (annotationScreenshotPinYCoordinate == null) {
			if (other.annotationScreenshotPinYCoordinate != null)
				return false;
		} else if (!annotationScreenshotPinYCoordinate.equals(other.annotationScreenshotPinYCoordinate))
			return false;
		if (annotationScreenshotWidth != other.annotationScreenshotWidth)
			return false;
		if (annotationTitle == null) {
			if (other.annotationTitle != null)
				return false;
		} else if (!annotationTitle.equals(other.annotationTitle))
			return false;
		if (annotationTypeId != other.annotationTypeId)
			return false;
		if (emojiId != other.emojiId)
			return false;
		if (parentURLId != other.parentURLId)
			return false;
		if (pinContentId != other.pinContentId)
			return false;
		if (pinId != other.pinId)
			return false;
		if (pinXCoordinate == null) {
			if (other.pinXCoordinate != null)
				return false;
		} else if (!pinXCoordinate.equals(other.pinXCoordinate))
			return false;
		if (pinYCoordinate == null) {
			if (other.pinYCoordinate != null)
				return false;
		} else if (!pinYCoordinate.equals(other.pinYCoordinate))
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (specificURL != other.specificURL)
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (useStatus != other.useStatus)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Annotation [annotationId=" + annotationId + ", annotationTitle=" + annotationTitle
				+ ", annotationDescription=" + annotationDescription + ", annotationMedia=" + annotationMedia
				+ ", annotationScreenshot=" + annotationScreenshot + ", annotationScreenshotHeight="
				+ annotationScreenshotHeight + ", annotationScreenshotWidth=" + annotationScreenshotWidth
				+ ", annotationScreenshotPinXCoordinate=" + annotationScreenshotPinXCoordinate
				+ ", annotationScreenshotPinYCoordinate=" + annotationScreenshotPinYCoordinate + ", emojiId=" + emojiId
				+ ", pinId=" + pinId + ", pinContentId=" + pinContentId + ", annotationTypeId=" + annotationTypeId
				+ ", annotationHashtagId=" + annotationHashtagId + ", parentURLId=" + parentURLId + ", specificURL="
				+ specificURL + ", pinXCoordinate=" + pinXCoordinate + ", pinYCoordinate=" + pinYCoordinate
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", userId=" + userId + "]";
	}
	
	
}