package com.moomoon.domain;

import java.util.Date;

public class MemberVO {

//	userId VARCHAR(50) NOT NULL,
//	userPass VARCHAR(100) NOT NULL,
//	userName VARCHAR(30) NOT NULL,
//	userPhon VARCHAR(20) NOT NULL,
//	useraddr1 VARCHAR(20) NULL,
//	useraddr2 VARCHAR(50) NULL,
//	useraddr3 VARCHAR(50) NULL,
//	regiDate TIMESTAMP DEFAULT NOW(),
//	verify INT DEFAULT 0,
//	primary KEY(userId)
	private String userId;
	private String userPass;
	private String userName;
	private String userPhon;
	private String useraddr1;
	private String useraddr2;
	private String useraddr3;
	private Date regiDate;
	private int verify;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhon() {
		return userPhon;
	}
	public void setUserPhon(String userPhon) {
		this.userPhon = userPhon;
	}
	public String getUseraddr1() {
		return useraddr1;
	}
	public void setUseraddr1(String useraddr1) {
		this.useraddr1 = useraddr1;
	}
	public String getUseraddr2() {
		return useraddr2;
	}
	public void setUseraddr2(String useraddr2) {
		this.useraddr2 = useraddr2;
	}
	public String getUseraddr3() {
		return useraddr3;
	}
	public void setUseraddr3(String useraddr3) {
		this.useraddr3 = useraddr3;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}

	
	
	
}
