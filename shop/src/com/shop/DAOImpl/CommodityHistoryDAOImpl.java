package com.shop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.DAO.CommodityHistoryDAO;
import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;

public class CommodityHistoryDAOImpl implements CommodityHistoryDAO{
	Connection conn;
	/***
	 * ���幹�췽��
	 * @param conn
	 */
	public CommodityHistoryDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public CommodityHistoryDAOImpl() {
		super();
	}
	
	
	/***
	 * ɾ����Ʒ��ʷ��¼
	 * 
	 */
	public boolean doDel(int hId) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {

			String sql = "delete commodityhistory where h_id = ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1, hId);
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
	 * ������Ʒ��ʷ��¼
	 * 
	 */
	public boolean doIns(CommodityHistoryPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "insert into commodityhistory (h_id,c_num,h_inc,h_outc,c_name) values(?,?,?,?,?)";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1,pojo.gethId());
			pstat.setString(2, pojo.getcNum());
			pstat.setInt(3,pojo.gethInC());
			pstat.setInt(4,pojo.gethOutC());
			pstat.setString(5,pojo.getcName());
			
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
	 * �޸���Ʒ��ʷ��¼
	 * 
	 */
	public boolean doUpd(CommodityHistoryPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "update commodityhistory set c_num = ?,h_inc = ?,h_outc = ? where h_id = ?";
			pstat = this.conn.prepareStatement(sql);
			
			pstat.setString(1, pojo.getcNum());
			pstat.setInt(2,pojo.gethInC());
			pstat.setInt(3,pojo.gethOutC());
			pstat.setInt(4,pojo.gethId());
			
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
	 * ��ѯ������Ʒ��ʷ��¼
	 * 
	 */
	public List<CommodityHistoryPOJO> findAll() {
		List<CommodityHistoryPOJO> list = new ArrayList<CommodityHistoryPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select h_id,c_num,h_inc,h_outc from commodityhistory";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			while(res.next()){
				int h_id = res.getInt(1);
				String c_num = res.getString(2);
				int h_inc = res.getInt(3);
				int h_outc = res.getInt(4);
				
				CommodityHistoryPOJO pojo = new CommodityHistoryPOJO(h_id,c_num,h_inc,h_outc);
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
	 * ����Ʒ���Ʋ���
	 * 
	 */
	public List<CommodityHistoryPOJO> findByNum(String cNum) {
		List<CommodityHistoryPOJO> list = new ArrayList<CommodityHistoryPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select h_id,c_num,h_inc,h_outc,c_name from commodityhistory where c_num = ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, cNum);
			res = pstat.executeQuery();
			
			while(res.next()){
				int h_id = res.getInt(1);
				String c_num = res.getString(2);
				int h_inc = res.getInt(3);
				int h_outc = res.getInt(4);
				String c_name = res.getString(5);
				
				CommodityHistoryPOJO pojo = new CommodityHistoryPOJO(h_id,c_num,h_inc,h_outc,c_name);
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
	 * ����
	 * 
	 */
	public boolean doInC(int hinc,String cnum) {
		return true;
	}

	/***
	 * ����bId���ֵ
	 * 
	 */
	public int findMax() {
		int max = 1;
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select max(h_id) from commodityhistory";
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
	 * ��ҳ������
	 * 
	 */
	public List<CommodityHistoryPOJO> findByYNum(int num) {
		List<CommodityHistoryPOJO> list = new ArrayList<CommodityHistoryPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select * from (select rownum no,h_id,c_num,h_inc,h_outc from commodityhistory where rownum < " + (num*10+1) + ") where no > " + ((num-1)*10);
			pstat = this.conn.prepareStatement(sql);

			res = pstat.executeQuery();
			
			while(res.next()){
				int c_id = res.getInt(2);
				String c_num = res.getString(3);
				int h_inc = res.getInt(4);
				int h_outc = res.getInt(5);
				
				
				CommodityHistoryPOJO pojo = new CommodityHistoryPOJO(c_id,c_num,h_inc,h_outc);
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
	 * �����ֲ���
	 * 
	 */
	public List<CommodityHistoryPOJO> findByName(String cName) {
		List<CommodityHistoryPOJO> list = new ArrayList<CommodityHistoryPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select h_id,c_num,h_inc,h_outc,c_name from commodityhistory where c_name like ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, "%" + cName + "%");
			res = pstat.executeQuery();
			
			while(res.next()){
				int h_id = res.getInt(1);
//				System.out.println("h_id" + h_id);
				String c_num = res.getString(2);
//				System.out.println("c_num" + c_num);
				int h_inc = res.getInt(3);
//				System.out.println("h_inc" + h_inc);
				int h_outc = res.getInt(4);
//				System.out.println("h_outc" + h_outc);
				String c_name = res.getString(5);	
//				System.out.println("c_name" + c_name);
				CommodityHistoryPOJO pojo = new CommodityHistoryPOJO(h_id,c_num,h_inc,h_outc,c_name);
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

	//������������
	public List<CommodityHistoryPOJO> findT() {
		List<CommodityHistoryPOJO> list = new ArrayList<CommodityHistoryPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select h_id,c_num,h_inc,h_outc from commodityhistory order by h_outc DESC";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			while(res.next()){
				int h_id = res.getInt(1);
				String c_num = res.getString(2);
				int h_inc = res.getInt(3);
				int h_outc = res.getInt(4);
				
				CommodityHistoryPOJO pojo = new CommodityHistoryPOJO(h_id,c_num,h_inc,h_outc);
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
