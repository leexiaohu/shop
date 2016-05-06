package com.shop.DAO;

import java.util.List;

import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;


public interface CommodityDAO {
	public boolean doIns(CommodityPOJO pojo);//新增
	public boolean doDel(int cId);//删除
	public boolean doUpd(CommodityPOJO pojo);//修改
	public List<CommodityPOJO> findAll();//查找全部
	public List<CommodityPOJO> findById(int cId);//按Id查找
	public List<CommodityPOJO> findByName(String cName);//按名字查找
	public List<CommodityPOJO> findByNum(int num);//按页数查找
	public int findMax();//查找cId最大值
	public List<CommodityPOJO> findBycNum(String cNum);//按cNum查找
}
