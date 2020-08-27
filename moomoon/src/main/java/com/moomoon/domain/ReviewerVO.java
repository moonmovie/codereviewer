package com.moomoon.domain;

public class ReviewerVO {
//	reviewer VARCHAR(50) NOT NULL PRIMARY KEY,
//	lang TEXT NOT NULL,
//	star FLOAT DEFAULT 0 NOT NULL,
//	FOREIGN KEY(reviewer) REFERENCES members(userId)
	
	private String reviewer;
	private String lang;
	private float star;
	
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	
}
