package com.shop.POJO;

import java.io.Serializable;
import java.util.Date;

public class CommodityByPOJO implements Serializable{
	private int bId;
	private int uId;
	private String uName;
	private int cId;
	private String cName;
	private int bCount;
	private int bSum;
	private Date bDate;
	/***
	 * 
	 * GetterSetter方法
	 */
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
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
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public int getbSum() {
		return bSum;
	}
	public void setbSum(int bSum) {
		this.bSum = bSum;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
	/***
	 * 构造方法
	 */
	public CommodityByPOJO() {
		super();
	}
	public CommodityByPOJO(int bId, int uId, String uName, int cId, String cName,
			int bCount, int bSum, Date bDate) {
		super();
		this.bId = bId;
		this.uId = uId;
		this.uName = uName;
		this.cId = cId;
		this.cName = cName;
		this.bCount = bCount;
		this.bSum = bSum;
		this.bDate = bDate;
	}
	
	
}
