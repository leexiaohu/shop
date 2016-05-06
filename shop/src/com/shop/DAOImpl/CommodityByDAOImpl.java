package com.shop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.DAO.CommodityByDAO;
import com.shop.POJO.AdminPOJO;
import com.shop.POJO.CommodityByPOJO;

public class CommodityByDAOImpl implements CommodityByDAO{
	Connection conn;
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public CommodityByDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public CommodityByDAOImpl() {
		super();
	}
	
	
	/***
	 * 新增购买记录
	 */
	public boolean doIns(CommodityByPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "insert into commodityby (b_id,u_id,u_name,c_id,c_name,b_count,b_sum,b_date) values(?,?,?,?,?,?,?,?)";
			pstat = this.conn.prepareStatement(sql);
			
			pstat.setInt(1,pojo.getbId());
			pstat.setInt(2,pojo.getuId());
			pstat.setString(3,pojo.getuName());
			pstat.setInt(4,pojo.getcId());
			pstat.setString(5,pojo.getcName());
			pstat.setInt(6,pojo.getbCount());
			pstat.setInt(7,pojo.getbSum());
			pstat.setDate(8, new java.sql.Date(pojo.getbDate().getTime()));
			
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
	 * 查询所有购买记录
	 */
	public List<CommodityByPOJO> findAll() {
		List<CommodityByPOJO> list = new ArrayList<CommodityByPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select b_id,u_id,u_name,c_id,c_name,b_count,b_sum,b_date from commodityby";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			
			while(res.next()){
				int b_id = res.getInt(1);
				int u_id = res.getInt(2);
				String u_name = res.getString(3);
				int c_id = res.getInt(4);
				String c_name = res.getString(5);
				int b_count = res.getInt(6);
				int b_sum = res.getInt(7);
				java.util.Date b_date = res.getDate(8);
				
				CommodityByPOJO pojo = new CommodityByPOJO(b_id,u_id,u_name,c_id,c_name,b_count,b_sum,b_date);
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
	 * 查找uId最大值
	 */
	public int findMax() {
		int max = 1;
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select max(b_id) from commodityby";
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
}
