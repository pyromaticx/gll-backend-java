package com.gll.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ThumbnailDot {
	private String background;
	private String border;
	@Column(name="xTop")
	private String top;
	@Column(name="yLeft")
	private String left;

	public ThumbnailDot() {
	}

	public ThumbnailDot(String background, String border, String top, String left) {
		super();
		this.background = background;
		this.border = border;
		this.top = top;
		this.left = left;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
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
		return "ThumbnailDot [background=" + background + ", border=" + border + ", top=" + top + ", left=" + left
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((border == null) ? 0 : border.hashCode());
		result = prime * result + ((top == null) ? 0 : top.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
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
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		if (border == null) {
			if (other.border != null)
				return false;
		} else if (!border.equals(other.border))
			return false;
		if (top == null) {
			if (other.top != null)
				return false;
		} else if (!top.equals(other.top))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		return true;
	}

	
}
