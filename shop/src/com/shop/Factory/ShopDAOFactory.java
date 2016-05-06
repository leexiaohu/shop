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
	//����Ա��
	public static AdminDAO getAdminDAOInsancet(){
		return new AdminDAOProxy();
	}
	//��Ʒ��
	public static CommodityDAO getCommodityDAOInsancet(){
		return new CommodityDAOProxy();
	}
	//��Ʒ��¼��
	public static CommodityHistoryDAO getCommodityHistoryDAOInsancet(){
		return new CommodityHistoryDAOProxy();
	}
	//�û���
	public static UserClientDAO getUserClientDAOInsancet(){
		return new UserClientDAOProxy();
	}
	//��Ʒ�����
	public static CommodityByDAO getCommodityByDAOInsancet(){
		return new CommodityByDAOProxy();
	}
	//�ʽ������
	public static FindsFlowDAO getFindsFlowDAOInsancet(){
		return new FindsFlowDAOProxy();
	}

}
