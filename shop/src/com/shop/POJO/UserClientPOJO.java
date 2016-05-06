package com.shop.POJO;

import java.io.Serializable;

public class UserClientPOJO implements Serializable{
	private int uId;
	private String uName;
	private String uPsw;
	private String uNum;
	private String uRName;
	private String uTel;
	private String uAdd;
	private String uEmail;
	private int uStatus;
	/***
	 * 
	 * GetterSetter方法
	 */
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPsw() {
		return uPsw;
	}
	public void setuPsw(String uPsw) {
		this.uPsw = uPsw;
	}
	public String getuNum() {
		return uNum;
	}
	public void setuNum(String uNum) {
		this.uNum = uNum;
	}
	public String getuRName() {
		return uRName;
	}
	public void setuRName(String uRName) {
		this.uRName = uRName;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public String getuAdd() {
		return uAdd;
	}
	public void setuAdd(String uAdd) {
		this.uAdd = uAdd;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public int getuStatus() {
		return uStatus;
	}
	public void setuStatus(int uStatus) {
		this.uStatus = uStatus;
	}
	/***
	 * 构造方法
	 */
	public UserClientPOJO() {
		super();
	}
	public UserClientPOJO(int uId, String uName, String uPsw, String uNum,
			String uRName, String uTel, String uAdd, String uEmail, int uStatus) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPsw = uPsw;
		this.uNum = uNum;
		this.uRName = uRName;
		this.uTel = uTel;
		this.uAdd = uAdd;
		this.uEmail = uEmail;
		this.uStatus = uStatus;
	}
	
	
}
