package com.shop.DAO;

import java.util.List;

import com.shop.POJO.CommodityByPOJO;

public interface CommodityByDAO {
	public boolean doIns(CommodityByPOJO pojo);//����
	public List<CommodityByPOJO> findAll();//����ȫ��
	public int findMax();//����uId���ֵ
}
