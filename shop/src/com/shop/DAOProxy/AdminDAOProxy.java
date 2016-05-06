package com.shop.DAOProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.DAO.AdminDAO;
import com.shop.DAOImpl.AdminDAOImpl;
import com.shop.POJO.AdminPOJO;
import com.shop.PUB.GetConnection;

public class AdminDAOProxy implements AdminDAO{
	Connection conn;
	private AdminDAOImpl impl;
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public AdminDAOProxy(){
		try {
			this.conn = GetConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		impl = new AdminDAOImpl(conn);
	}
	
	/***
	 * 删除账号
	 */
	public boolean doDel(int aId) {
		boolean bool = impl.doDel(aId);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	/***
	 * 新增账户
	 */
	public boolean doIns(AdminPOJO pojo) {
		boolean bool = impl.doIns(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	/***
	 * 修改账户
	 */
	public boolean doUpd(AdminPOJO pojo) {
		boolean bool = impl.doUpd(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	
	/***
	 * 查找所有账户
	 */
	public List<AdminPOJO> findAll() {
		List<AdminPOJO> list = impl.findAll();
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
	public List<AdminPOJO> findByName(String aName) {
		List<AdminPOJO> list = impl.findByName(aName);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	/***
	 * 按名字密码查找
	 */
	public List<AdminPOJO> findByNP(String aName, String aPsw) {
		List<AdminPOJO> list = impl.findByNP(aName,aPsw);
		//System.out.println(aName + "----"  + aPsw);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	
}

