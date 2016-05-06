package com.shop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.DAO.AdminDAO;
import com.shop.POJO.AdminPOJO;
import com.shop.PUB.GetConnection;

public class AdminDAOImpl implements AdminDAO{
	Connection conn;	
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public AdminDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public AdminDAOImpl() {
		super();
	}
	/***
	 * 删除账号
	 */
	public boolean doDel(int aId) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {

			String sql = "delete admin where a_id = ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1, aId);
			pstat.execute();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bool;
	}
	/***
	 * 新增账户
	 */
	public boolean doIns(AdminPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {

			String sql = "insert into admin (a_id,a_name,a_psw,a_auto) values(?,?,?,?)";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1,pojo.getaId());
			pstat.setString(2,pojo.getaName());
			pstat.setString(3,pojo.getaPsw());
			pstat.setInt(4,pojo.getaAuto());
			
			pstat.execute();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				pstat.close();

			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		return bool;
	}
	/***
	 * 修改账户
	 */
	public boolean doUpd(AdminPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {

			String sql = "update admin set a_name = ?,a_psw = ?,a_auto = ? where a_id = ?";
			pstat = this.conn.prepareStatement(sql);
			
			pstat.setString(1,pojo.getaName());
			pstat.setString(2,pojo.getaPsw());
			pstat.setInt(3,pojo.getaAuto());
			pstat.setInt(4,pojo.getaId());
			
			pstat.execute();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				pstat.close();

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return bool;
	}
	
	/***
	 * 查找所有账户
	 */
	public List<AdminPOJO> findAll() {
		List<AdminPOJO> list = new ArrayList<AdminPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select a_id,a_name,a_psw,a_auto from admin";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			while(res.next()){
				int a_id = res.getInt(1);
				String a_name = res.getString(2);
				String a_psw = res.getString(3);
				int a_auto = res.getInt(4);
				
				AdminPOJO pojo = new AdminPOJO(a_id,a_name,a_psw,a_auto);
				list.add(pojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				res.close();
				pstat.close();

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}

	/***
	 * 按名字查找
	 */
	public List<AdminPOJO> findByName(String aName) {
		List<AdminPOJO> list = new ArrayList<AdminPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select a_id,a_name,a_psw,a_auto from admin where a_name like ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, "%" + aName + "%");
			res = pstat.executeQuery();
			
			while(res.next()){
				int a_id = res.getInt(1);
				String a_name = res.getString(2);
				String a_psw = res.getString(3);
				int a_auto = res.getInt(4);
				
				AdminPOJO pojo = new AdminPOJO(a_id,a_name,a_psw,a_auto);
				list.add(pojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				res.close();
				pstat.close();

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/***
	 * 按名字密码查找
	 */
	public List<AdminPOJO> findByNP(String aName, String aPsw) {
		List<AdminPOJO> list = new ArrayList<AdminPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select a_id,a_name,a_psw,a_auto from admin where a_name = '" + aName + "' and a_psw = '" + aPsw + "'";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			while(res.next()){
				int a_id = res.getInt(1);
				String a_name = res.getString(2);
				String a_psw = res.getString(3);
				int a_auto = res.getInt(4);
				//System.out.println(a_id + " " + a_name + " " + a_psw + " " + a_auto);
				AdminPOJO pojo = new AdminPOJO(a_id,a_name,a_psw,a_auto);
				list.add(pojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				res.close();
				pstat.close();

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
}
