package com.shop.Factory;

import com.shop.DAO.AdminDAO;
import com.shop.DAO.CommodityByDAO;
import com.shop.DAO.CommodityDAO;
import com.shop.DAO.CommodityHistoryDAO;
import com.shop.DAO.FindsFlowDAO;
import com.shop.DAO.UserClientDAO;
import com.shop.DAOProxy.AdminDAOProxy;
import com.shop.DAOProxy.CommodityByDAOProxy;
import com.shop.DAOProxy.CommodityDAOProxy;
import com.shop.DAOProxy.CommodityHistoryDAOProxy;
import com.shop.DAOProxy.FindsFlowDAOProxy;
import com.shop.DAOProxy.UserClientDAOProxy;


public class ShopDAOFactory {
	//管理员表
	public static AdminDAO getAdminDAOInsancet(){
		return new AdminDAOProxy();
	}
	//商品表
	public static CommodityDAO getCommodityDAOInsancet(){
		return new CommodityDAOProxy();
	}
	//商品记录表
	public static CommodityHistoryDAO getCommodityHistoryDAOInsancet(){
		return new CommodityHistoryDAOProxy();
	}
	//用户表
	public static UserClientDAO getUserClientDAOInsancet(){
		return new UserClientDAOProxy();
	}
	//商品购买表
	public static CommodityByDAO getCommodityByDAOInsancet(){
		return new CommodityByDAOProxy();
	}
	//资金流向表
	public static FindsFlowDAO getFindsFlowDAOInsancet(){
		return new FindsFlowDAOProxy();
	}

}
