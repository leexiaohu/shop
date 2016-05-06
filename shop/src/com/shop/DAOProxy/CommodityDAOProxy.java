package com.shop.DAOProxy;

import java.sql.Connection;
import java.util.List;

import com.shop.DAO.CommodityDAO;
import com.shop.DAOImpl.CommodityDAOImpl;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.PUB.GetConnection;

public class CommodityDAOProxy implements CommodityDAO{
	Connection conn;
	private CommodityDAOImpl impl;
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public CommodityDAOProxy() {
		try {
			this.conn = GetConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		impl = new CommodityDAOImpl(conn);
	}
	
	
	/***
	 * 删除商品
	 */
	public boolean doDel(int cId) {
		boolean bool = impl.doDel(cId);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	/***
	 * 新增商品
	 */
	public boolean doIns(CommodityPOJO pojo) {
		boolean bool = impl.doIns(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	/***
	 * 修改商品
	 */
	public boolean doUpd(CommodityPOJO pojo) {
		boolean bool = impl.doUpd(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	
	/***
	 * 查找所有员工
	 */
	public List<CommodityPOJO> findAll() {
		List<CommodityPOJO> list = impl.findAll();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/***
	 * 按名字查找
	 */
	public List<CommodityPOJO> findByName(String cName) {
		List<CommodityPOJO> list = impl.findByName(cName);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/***
	 * 按cId查找
	 */
	public List<CommodityPOJO> findById(int cId) {
		List<CommodityPOJO> list = impl.findById(cId);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/***
	 * 按页数查找
	 */
	public List<CommodityPOJO> findByNum(int num) {
		List<CommodityPOJO> list = impl.findByNum(num);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/***
	 * 查找cId最大值
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
	 * 按账户查找
	 * 
	 */
	public List<CommodityPOJO> findBycNum(String cNum) {
		List<CommodityPOJO> list = impl.findBycNum(cNum);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
}
