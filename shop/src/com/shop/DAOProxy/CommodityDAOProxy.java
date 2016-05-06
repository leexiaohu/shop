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
	 * ���幹�췽��
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
	 * ɾ����Ʒ
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
	 * ������Ʒ
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
	 * �޸���Ʒ
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
	 * ��������Ա��
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
	 * �����ֲ���
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
	 * ��cId����
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
	 * ��ҳ������
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
	 * ����cId���ֵ
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
	 * ���˻�����
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
