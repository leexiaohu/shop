package com.shop.DAOProxy;

import java.sql.Connection;
import java.util.List;

import com.shop.DAO.CommodityHistoryDAO;
import com.shop.DAOImpl.CommodityHistoryDAOImpl;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.PUB.GetConnection;

public class CommodityHistoryDAOProxy implements CommodityHistoryDAO{
	Connection conn;
	private CommodityHistoryDAOImpl impl;
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public CommodityHistoryDAOProxy() {
		try {
			this.conn = GetConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		impl = new CommodityHistoryDAOImpl(conn);
	}
	
	
	/***
	 * 删除商品历史记录
	 * 
	 */
	public boolean doDel(int hId) {
		boolean bool = impl.doDel(hId);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	
	/***
	 * 增加商品历史记录
	 * 
	 */
	public boolean doIns(CommodityHistoryPOJO pojo) {
		boolean bool = impl.doIns(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	
	/***
	 * 修改商品历史记录
	 * 
	 */
	public boolean doUpd(CommodityHistoryPOJO pojo) {
		boolean bool = impl.doUpd(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	/***
	 * 查询所有商品历史记录
	 * 
	 */
	public List<CommodityHistoryPOJO> findAll() {
		List<CommodityHistoryPOJO> list = impl.findAll();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/***
	 * 按商品名称查找
	 * 
	 */
	public List<CommodityHistoryPOJO> findByNum(String cNum) {
		List<CommodityHistoryPOJO> list = impl.findByNum(cNum);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}


	/***
	 * 进货
	 * 
	 */
	public boolean doInC(int hinc, String cnum) {
		return false;
	}


	/***
	 * 查找bId最大值
	 * 
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


	/***
	 * 按页数查找
	 * 
	 */
	public List<CommodityHistoryPOJO> findByYNum(int num) {
		List<CommodityHistoryPOJO> list = impl.findByYNum(num);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		} 
		return list;
	}


	/***
	 * 按名字查找
	 * 
	 */
	public List<CommodityHistoryPOJO> findByName(String cName) {
		List<CommodityHistoryPOJO> list = impl.findByName(cName);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}


	//按销货量查询
	public List<CommodityHistoryPOJO> findT() {
		List<CommodityHistoryPOJO> list = impl.findT();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
