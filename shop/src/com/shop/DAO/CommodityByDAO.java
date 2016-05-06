package com.shop.DAO;

import java.util.List;

import com.shop.POJO.CommodityByPOJO;

public interface CommodityByDAO {
	public boolean doIns(CommodityByPOJO pojo);//新增
	public List<CommodityByPOJO> findAll();//查找全部
	public int findMax();//查找uId最大值
}
