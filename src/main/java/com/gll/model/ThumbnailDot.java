package com.gll.model;

import javax.persistence.Embeddable;

@Embeddable
public class ThumbnailDot {
	private String background;
	private String border;
	private String xtop;
	private String yleft;

	public ThumbnailDot() {
	}

	public ThumbnailDot(String background, String border, String xtop, String yleft) {
		super();
		this.background = background;
		this.border = border;
		this.xtop = xtop;
		this.yleft = yleft;
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

	

	public String getXtop() {
		return xtop;
	}

	public void setXtop(String xtop) {
		this.xtop = xtop;
	}

	public String getYleft() {
		return yleft;
	}

	public void setYleft(String yleft) {
		this.yleft = yleft;
	}

	@Override
	public String toString() {
		return "ThumbnailDot [background=" + background + ", border=" + border + ", xtop=" + xtop + ", yleft=" + yleft
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((border == null) ? 0 : border.hashCode());
		result = prime * result + ((xtop == null) ? 0 : xtop.hashCode());
		result = prime * result + ((yleft == null) ? 0 : yleft.hashCode());
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
		if (xtop == null) {
			if (other.xtop != null)
				return false;
		} else if (!xtop.equals(other.xtop))
			return false;
		if (yleft == null) {
			if (other.yleft != null)
				return false;
		} else if (!yleft.equals(other.yleft))
			return false;
		return true;
	}

	
}
