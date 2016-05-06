package com.shop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.DAO.CommodityDAO;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;


public class CommodityDAOImpl implements CommodityDAO{
	Connection conn;
	/***
	 * 定义构造方法
	 * @param conn
	 */
	public CommodityDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public CommodityDAOImpl() {
		super();
	}
	
	/***
	 * 删除商品
	 */
	public boolean doDel(int cId) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {

			String sql = "delete commodity where c_id = ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1, cId);
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
	 * 新增商品
	 */
	public boolean doIns(CommodityPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "insert into commodity (c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status) values(?,?,?,?,?,?,?,?,?,?)";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1,pojo.getcId());
			pstat.setString(2, pojo.getcNum());
			pstat.setString(3, pojo.getcName());
			pstat.setString(4, pojo.getcFormat());
			pstat.setString(5, pojo.getcPrice());
			pstat.setString(6, pojo.getcContent());
			pstat.setString(7, pojo.getcImg());
			pstat.setDate(8, new java.sql.Date(pojo.getcIDate().getTime()));
			pstat.setDate(9, new java.sql.Date(pojo.getcODate().getTime()));
			pstat.setInt(10,pojo.getcStatus());
			
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
	 * 修改商品
	 */
	public boolean doUpd(CommodityPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {

			String sql = "update commodity set c_num = ?,c_name = ?,c_format = ?,c_price = ?,c_content = ?,c_img = ?, c_idate = ?,c_odate = ?,c_status = ? where c_id = ?";
			pstat = this.conn.prepareStatement(sql);
			
			pstat.setString(1, pojo.getcNum());
			pstat.setString(2, pojo.getcName());
			pstat.setString(3, pojo.getcFormat());
			pstat.setString(4, pojo.getcPrice());
			pstat.setString(5, pojo.getcContent());
			pstat.setString(6, pojo.getcImg());
			pstat.setDate(7, new java.sql.Date(pojo.getcIDate().getTime()));
			pstat.setDate(8, new java.sql.Date(pojo.getcODate().getTime()));
			pstat.setInt(9,pojo.getcStatus());
			pstat.setInt(10,pojo.getcId());

			
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
	 * 查找所有员工
	 */
	public List<CommodityPOJO> findAll() {
		List<CommodityPOJO> list = new ArrayList<CommodityPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status from commodity";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			while(res.next()){
				int c_id = res.getInt(1);
				String c_num = res.getString(2);
				String c_name = res.getString(3);
				String c_format = res.getString(4);
				String c_price = res.getString(5);
				String c_content = res.getString(6);
				String c_img = res.getString(7);
				java.util.Date c_idate = res.getDate(8);
				java.util.Date c_odate = res.getDate(9);
				int c_status = res.getInt(10);
				
				
				CommodityPOJO pojo = new CommodityPOJO(c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status);
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
	public List<CommodityPOJO> findByName(String cName) {
		List<CommodityPOJO> list = new ArrayList<CommodityPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status from commodity where c_name like ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, "%" + cName + "%");
			res = pstat.executeQuery();
			
			while(res.next()){
				int c_id = res.getInt(1);
				String c_num = res.getString(2);
				String c_name = res.getString(3);
				String c_format = res.getString(4);
				String c_price = res.getString(5);
				String c_content = res.getString(6);
				String c_img = res.getString(7);
				java.util.Date c_idate = res.getDate(8);
				java.util.Date c_odate = res.getDate(9);
				int c_status = res.getInt(10);
//				System.out.println(c_name);
				CommodityPOJO pojo = new CommodityPOJO(c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status);
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
	 * 按cId查找
	 */
	public List<CommodityPOJO> findById(int cId) {
		List<CommodityPOJO> list = new ArrayList<CommodityPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status from commodity where c_id = ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1,cId);
			res = pstat.executeQuery();
			
			while(res.next()){
				int c_id = res.getInt(1);
				String c_num = res.getString(2);
				String c_name = res.getString(3);
				String c_format = res.getString(4);
				String c_price = res.getString(5);
				String c_content = res.getString(6);
				String c_img = res.getString(7);
				java.util.Date c_idate = res.getDate(8);
				java.util.Date c_odate = res.getDate(9);
				int c_status = res.getInt(10);
				
				CommodityPOJO pojo = new CommodityPOJO(c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status);
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
	 * 按页数查找
	 */
	public List<CommodityPOJO> findByNum(int num) {
		List<CommodityPOJO> list = new ArrayList<CommodityPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select * from (select rownum no,c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status from commodity where rownum < " + (num*10+1) + ") where no > " + ((num-1)*10);
			pstat = this.conn.prepareStatement(sql);

			res = pstat.executeQuery();
			
			while(res.next()){
				int c_id = res.getInt(2);
				String c_num = res.getString(3);
				String c_name = res.getString(4);
				String c_format = res.getString(5);
				String c_price = res.getString(6);
				String c_content = res.getString(7);
				String c_img = res.getString(8);
				java.util.Date c_idate = res.getDate(9);
				java.util.Date c_odate = res.getDate(10);
				int c_status = res.getInt(11);
				
				CommodityPOJO pojo = new CommodityPOJO(c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status);
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
	 * 查找cId最大值
	 * 
	 */
	public int findMax() {
		int max = 1;
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select max(c_id) from commodity";
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
	/***
	 * 按账户查找
	 * 
	 */
	public List<CommodityPOJO> findBycNum(String cNum) {
		List<CommodityPOJO> list = new ArrayList<CommodityPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status from commodity where c_num = ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, cNum);
			res = pstat.executeQuery();
			
			while(res.next()){
				int c_id = res.getInt(1);
				String c_num = res.getString(2);
				String c_name = res.getString(3);
				String c_format = res.getString(4);
				String c_price = res.getString(5);
				String c_content = res.getString(6);
				String c_img = res.getString(7);
				java.util.Date c_idate = res.getDate(8);
				java.util.Date c_odate = res.getDate(9);
				int c_status = res.getInt(10);
				
				CommodityPOJO pojo = new CommodityPOJO(c_id,c_num,c_name,c_format,c_price,c_content,c_img,c_idate,c_odate,c_status);
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
