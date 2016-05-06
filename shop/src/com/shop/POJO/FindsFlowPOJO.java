package com.shop.POJO;

import java.io.Serializable;
import java.util.Date;

public class FindsFlowPOJO  implements Serializable{
	private int fId;
	private int uId;
	private String uName;
	private int fSum;
	private int fType;
	private Date fDate;
	private String fRemark;
	/***
	 * 
	 * GetterSetter方法
	 */
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
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
	public int getfSum() {
		return fSum;
	}
	public void setfSum(int fSum) {
		this.fSum = fSum;
	}
	public int getfType() {
		return fType;
	}
	public void setfType(int fType) {
		this.fType = fType;
	}
	public Date getfDate() {
		return fDate;
	}
	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}
	public String getfRemark() {
		return fRemark;
	}
	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}
	/***
	 * 构造方法
	 */
	public FindsFlowPOJO() {
		super();
	}
	public FindsFlowPOJO(int fId, int uId, String uName, int fSum, int fType,
			Date fDate, String fRemark) {
		super();
		this.fId = fId;
		this.uId = uId;
		this.uName = uName;
		this.fSum = fSum;
		this.fType = fType;
		this.fDate = fDate;
		this.fRemark = fRemark;
	}
	
	
	
}
