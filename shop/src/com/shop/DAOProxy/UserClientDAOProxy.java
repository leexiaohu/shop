package com.shop.DAOProxy;

import java.sql.Connection;
import java.util.List;

import com.shop.DAO.UserClientDAO;
import com.shop.DAOImpl.AdminDAOImpl;
import com.shop.DAOImpl.UserClientDAOImpl;
import com.shop.POJO.AdminPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.POJO.UserClientPOJO;
import com.shop.PUB.GetConnection;

public class UserClientDAOProxy implements UserClientDAO{
	Connection conn;
	private UserClientDAOImpl impl;
	
	public UserClientDAOProxy(){
		try {
			this.conn = GetConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		impl = new UserClientDAOImpl(conn);
	}
	//ɾ��
	public boolean doDel(int uId) {
		boolean bool = impl.doDel(uId);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	//����
	public boolean doIns(UserClientPOJO pojo) {
		boolean bool = impl.doIns(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	//�޸�
	public boolean doUpd(UserClientPOJO pojo) {
		boolean bool = impl.doUpd(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
	//��������
	public List<UserClientPOJO> findAll() {
		List<UserClientPOJO> list = impl.findAll();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//�����ֲ���
	public List<UserClientPOJO> findByName(String uName) {
		List<UserClientPOJO> list = impl.findByName(uName);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//��ҳ������
	public List<UserClientPOJO> findByNum(int num) {
		List<UserClientPOJO> list = impl.findByNum(num);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	//�������������
	public List<UserClientPOJO> findByNP(String uNum, String uPsw) {
		List<UserClientPOJO> list = impl.findByNP(uNum,uPsw);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//���˺Ų���
	public List<UserClientPOJO> findByUNum(String uNum) {
		List<UserClientPOJO> list = impl.findByUNum(uNum);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//����bId���ֵ
	public int findMax() {
		int max = impl.findMax();
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return max;
	}
	//ע��
	public boolean doReg(UserClientPOJO pojo) {
		boolean bool = impl.doReg(pojo);
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bool;
	}
}
