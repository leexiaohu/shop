package com.shop.DAOProxy;

import java.sql.Connection;
import java.util.List;

import com.shop.DAO.CommodityByDAO;
import com.shop.DAOImpl.AdminDAOImpl;
import com.shop.DAOImpl.CommodityByDAOImpl;
import com.shop.POJO.AdminPOJO;
import com.shop.POJO.CommodityByPOJO;
import com.shop.PUB.GetConnection;

public class CommodityByDAOProxy implements CommodityByDAO{
	Connection conn;
	private CommodityByDAOImpl impl;
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public CommodityByDAOProxy(){
		try {
			this.conn = GetConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		impl = new CommodityByDAOImpl(conn);
	}

	
	/***
	 * 新增购买记录
	 */
	public boolean doIns(CommodityByPOJO pojo) {
		boolean bool = impl.doIns(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	
	/***
	 * 查询所有购买记录
	 */
	public List<CommodityByPOJO> findAll() {
		List<CommodityByPOJO> list = impl.findAll();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/***
	 * 查找uId最大值
	 */
	public int findMax() {
		int max = impl.findMax();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return max;
	}
}
