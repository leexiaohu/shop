package com.shop.POJO;

import java.io.Serializable;

public class AdminPOJO implements Serializable{
	private int aId;
	private String aName;
	private String aPsw;
	private int aAuto;
	
	/***
	 * 
	 * GetterSetter方法
	 */
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPsw() {
		return aPsw;
	}
	public void setaPsw(String aPsw) {
		this.aPsw = aPsw;
	}
	public int getaAuto() {
		return aAuto;
	}
	public void setaAuto(int aAuto) {
		this.aAuto = aAuto;
	}
	/***
	 * 构造方法
	 */
	public AdminPOJO() {
		super();
	}
	public AdminPOJO(int aId, String aName, String aPsw, int aAuto) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aPsw = aPsw;
		this.aAuto = aAuto;
	}
	
	
	
	
}
