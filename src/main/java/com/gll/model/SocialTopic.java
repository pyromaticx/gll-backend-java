package com.gll.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class SocialTopic implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String topic;

	public SocialTopic() {

	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	@Override
	public String toString() {
		return "SocialTopic [topic=" + topic + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		SocialTopic other = (SocialTopic) obj;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

}
