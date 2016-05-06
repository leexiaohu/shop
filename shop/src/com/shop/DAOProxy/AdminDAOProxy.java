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
	 * ���幹�췽��
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
	 * ɾ���˺�
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
	 * �����˻�
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
	 * �޸��˻�
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
	 * ���������˻�
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
	 * �����ֲ���
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
	 * �������������
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

