package com.shop.DAOProxy;

import java.sql.Connection;
import java.util.List;

import com.shop.DAO.FindsFlowDAO;
import com.shop.DAOImpl.FindsFlowDAOImpl;
import com.shop.POJO.AdminPOJO;
import com.shop.POJO.FindsFlowPOJO;
import com.shop.PUB.GetConnection;

public class FindsFlowDAOProxy implements FindsFlowDAO{
	Connection conn;
	private FindsFlowDAOImpl impl;
	
	public FindsFlowDAOProxy() {
		try {
			this.conn = GetConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		impl = new FindsFlowDAOImpl(conn);
	}

	//新增
	public boolean doIns(FindsFlowPOJO pojo) {
		boolean bool = impl.doIns(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	//按用户名查找
	public List<FindsFlowPOJO> findByUName(String uName) {
		List<FindsFlowPOJO> list = impl.findByUName(uName);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//查找fId最大值
	public int findMax() {
		int max = impl.findMax();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return max;
	}
	//查询总收入
	public List<FindsFlowPOJO> findIn(String username) {
		List<FindsFlowPOJO> list = impl.findIn(username);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//查询总支出
	public List<FindsFlowPOJO> finout(String username) {
		List<FindsFlowPOJO> list = impl.finout(username);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
