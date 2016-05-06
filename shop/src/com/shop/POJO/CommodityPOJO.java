package com.shop.POJO;

import java.util.Date;

public class CommodityPOJO {
	private int cId;
	private String cNum;
	private String cName;
	private String cFormat;
	private String cPrice;
	private String cContent;
	private String cImg;
	private Date cIDate;
	private Date cODate;
	private int cStatus;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcFormat() {
		return cFormat;
	}
	public void setcFormat(String cFormat) {
		this.cFormat = cFormat;
	}
	

	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcImg() {
		return cImg;
	}
	public void setcImg(String cImg) {
		this.cImg = cImg;
	}
	public CommodityPOJO() {
		super();
	}
	
	public String getcPrice() {
		return cPrice;
	}
	
	
	public Date getcIDate() {
		return cIDate;
	}
	public void setcIDate(Date cIDate) {
		this.cIDate = cIDate;
	}
	public Date getcODate() {
		return cODate;
	}
	public void setcODate(Date cODate) {
		this.cODate = cODate;
	}
	public void setcPrice(String cPrice) {
		this.cPrice = cPrice;
	}
	
	public int getcStatus() {
		return cStatus;
	}
	public void setcStatus(int cStatus) {
		this.cStatus = cStatus;
	}
	
	
	
	public CommodityPOJO(int cId, String cNum, String cName, String cFormat,
			String cPrice, String cContent, String cImg, Date cIDate,
			Date cODate, int cStatus) {
		super();
		this.cId = cId;
		this.cNum = cNum;
		this.cName = cName;
		this.cFormat = cFormat;
		this.cPrice = cPrice;
		this.cContent = cContent;
		this.cImg = cImg;
		this.cIDate = cIDate;
		this.cODate = cODate;
		this.cStatus = cStatus;
	}

	
}
