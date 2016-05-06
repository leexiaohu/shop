package com.shop.POJO;

public class CommodityHistoryPOJO {
	private int hId;
	private String cNum;
	private int hInC;
	private int hOutC;
	private String cName;
	/***
	 * 
	 * GetterSetter方法
	 */
	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public int gethId() {
		return hId;
	}
	
	
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public int gethInC() {
		return hInC;
	}
	public void sethInC(int hInC) {
		this.hInC = hInC;
	}
	public int gethOutC() {
		return hOutC;
	}
	public void sethOutC(int hOutC) {
		this.hOutC = hOutC;
	}

	/***
	 * 构造方法
	 */
	public CommodityHistoryPOJO(int hId, String cNum, int hInC, int hOutC) {
		super();
		this.hId = hId;
		this.cNum = cNum;
		this.hInC = hInC;
		this.hOutC = hOutC;
	}


	public CommodityHistoryPOJO(int hId, String cNum, int hInC, int hOutC,
			String cName) {
		super();
		this.hId = hId;
		this.cNum = cNum;
		this.hInC = hInC;
		this.hOutC = hOutC;
		this.cName = cName;
	}
	
	
	
	
	
	
}
