package com.shop.DAO;

import java.util.List;

import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;


public interface CommodityHistoryDAO {
	public boolean doIns(CommodityHistoryPOJO pojo);//新增
	public boolean doDel(int hId);//删除
	public boolean doUpd(CommodityHistoryPOJO pojo);//修改
	public List<CommodityHistoryPOJO> findAll();//查找全部
	public List<CommodityHistoryPOJO> findByNum(String cNum);//按cNum查找
	public boolean doInC(int hinc,String cnum);//进货
	public int findMax();//查找hId最大值s
	public List<CommodityHistoryPOJO> findByYNum(int num);//按页数查找
	public List<CommodityHistoryPOJO> findByName(String cName);//按名字查找
	public List<CommodityHistoryPOJO> findT();//按销货量排序
}
