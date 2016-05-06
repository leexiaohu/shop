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
	 * ���幹�췽��
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
	 * ɾ����Ʒ��ʷ��¼
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
	 * ������Ʒ��ʷ��¼
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
	 * �޸���Ʒ��ʷ��¼
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
	 * ��ѯ������Ʒ��ʷ��¼
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
	 * ����Ʒ���Ʋ���
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
	 * ����
	 * 
	 */
	public boolean doInC(int hinc, String cnum) {
		return false;
	}


	/***
	 * ����bId���ֵ
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
	 * ��ҳ������
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
	 * �����ֲ���
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


	//����������ѯ
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
