package com.shop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shop.DAO.FindsFlowDAO;
import com.shop.POJO.AdminPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.POJO.FindsFlowPOJO;

public class FindsFlowDAOImpl implements FindsFlowDAO{
	Connection conn;	
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public FindsFlowDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public FindsFlowDAOImpl() {
		super();
	}
	
	
	/***
	 * 新增资金流向
	 * 
	 */
	public boolean doIns(FindsFlowPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "insert into findsflow (f_id,u_id,u_name,f_sum,f_type,f_date,f_remarks) values(?,?,?,?,?,?,?)";
			pstat = this.conn.prepareStatement(sql);
			
			pstat.setInt(1,pojo.getfId());
			pstat.setInt(2,pojo.getuId());
			pstat.setString(3,pojo.getuName());
			pstat.setInt(4,pojo.getfSum());
			pstat.setInt(5,pojo.getfType());
			pstat.setDate(6, new java.sql.Date(pojo.getfDate().getTime()));
			pstat.setString(7,pojo.getfRemark());
			
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
	 * 按用户名查找
	 * 
	 */
	public List<FindsFlowPOJO> findByUName(String uName) {
		List<FindsFlowPOJO> list = new ArrayList<FindsFlowPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select f_id,u_id,u_name,f_sum,f_type,f_date,f_remarks from findsflow where u_name like ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, "%" + uName + "%");
			res = pstat.executeQuery();
			
			while(res.next()){
				int f_id = res.getInt(1);
				int u_id = res.getInt(2);
				String u_name = res.getString(3);
				int f_sum = res.getInt(4);
				int f_type = res.getInt(5);
				Date f_date = res.getDate(6);
				String f_remarks = res.getString(7);
				
				FindsFlowPOJO pojo = new FindsFlowPOJO(f_id,u_id,u_name,f_sum,f_type,f_date,f_remarks);
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
	
	//查找fId最大值
	public int findMax() {
		int max = 1;
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select max(f_id) from findsflow";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			while(res.next()){
				max = res.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return max;
	}
	//查找总收入
	public List<FindsFlowPOJO> findIn(String username) {
		List<FindsFlowPOJO> list = new ArrayList<FindsFlowPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select f_id,u_id,u_name,f_sum,f_type,f_date,f_remarks from findsflow where (f_type = 1 or f_type = 3) and u_name = " + username;
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			while(res.next()){
				int f_id = res.getInt(1);
				int u_id = res.getInt(2);
				String u_name = res.getString(3);
				int f_sum = res.getInt(4);
				int f_type = res.getInt(5);
				Date f_date = res.getDate(6);
				String f_remarks = res.getString(7);
				
				FindsFlowPOJO pojo = new FindsFlowPOJO(f_id,u_id,u_name,f_sum,f_type,f_date,f_remarks);
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
	//查询总支出
	public List<FindsFlowPOJO> finout(String username) {
		List<FindsFlowPOJO> list = new ArrayList<FindsFlowPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select f_id,u_id,u_name,f_sum,f_type,f_date,f_remarks from findsflow where (f_type = 2 or f_type = 4 or f_type = 5) and u_name = " + username;
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			while(res.next()){
				int f_id = res.getInt(1);
				int u_id = res.getInt(2);
				String u_name = res.getString(3);
				int f_sum = res.getInt(4);
				int f_type = res.getInt(5);
				Date f_date = res.getDate(6);
				String f_remarks = res.getString(7);
				
				FindsFlowPOJO pojo = new FindsFlowPOJO(f_id,u_id,u_name,f_sum,f_type,f_date,f_remarks);
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
