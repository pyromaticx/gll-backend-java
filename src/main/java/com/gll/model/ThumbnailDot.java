package com.gll.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ThumbnailDot {
	@Column(name="xTop")
	private String top;
	@Column(name="yLeft")
	private String left;

	public ThumbnailDot() {
	}



	public ThumbnailDot(String top, String left) {
		super();
		this.top = top;
		this.left = left;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}



	@Override
	public String toString() {
		return "ThumbnailDot [ top=" + top + ", left=" + left + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((top == null) ? 0 : top.hashCode());
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
		ThumbnailDot other = (ThumbnailDot) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (top == null) {
			if (other.top != null)
				return false;
		} else if (!top.equals(other.top))
			return false;
		return true;
	}




}
