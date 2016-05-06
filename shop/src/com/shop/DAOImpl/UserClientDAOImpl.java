package com.shop.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.DAO.UserClientDAO;
import com.shop.POJO.AdminPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.POJO.UserClientPOJO;

public class UserClientDAOImpl implements UserClientDAO{
	Connection conn;	
	public UserClientDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public UserClientDAOImpl() {
		super();
	}
	
	
	//删除
	public boolean doDel(int uId) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "delete userclient where u_id = ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1, uId);
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
	//新增
	public boolean doIns(UserClientPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "insert into userclient (u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status) values(?,?,?,?,?,?,?,?,?)";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1,pojo.getuId());
			pstat.setString(2,pojo.getuName());
			pstat.setString(3,pojo.getuPsw());
			pstat.setString(4,pojo.getuNum());
			pstat.setString(5,pojo.getuRName());
			pstat.setString(6,pojo.getuTel());
			pstat.setString(7,pojo.getuAdd());
			pstat.setString(8,pojo.getuEmail());
			pstat.setInt(9,pojo.getuStatus());
			
			
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
	
	//修改
	public boolean doUpd(UserClientPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "update userclient set u_name = ?,u_psw = ?,u_num = ?,u_rname = ?,u_tel = ?,u_add = ?,u_email = ?,u_status = ? where u_id = ?";
			pstat = this.conn.prepareStatement(sql);
			
			pstat.setString(1,pojo.getuName());
			pstat.setString(2,pojo.getuPsw());
			pstat.setString(3,pojo.getuNum());
			pstat.setString(4,pojo.getuRName());
			pstat.setString(5,pojo.getuTel());
			pstat.setString(6,pojo.getuAdd());
			pstat.setString(7,pojo.getuEmail());
			pstat.setInt(8, pojo.getuStatus());
			pstat.setInt(9,pojo.getuId());
			
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
	
	//查找所有
	public List<UserClientPOJO> findAll() {
		List<UserClientPOJO> list = new ArrayList<UserClientPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status from userclient";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			
			while(res.next()){
				int u_id = res.getInt(1);
				String u_name = res.getString(2);
				String u_psw = res.getString(3);
				String u_num = res.getString(4);
				String u_rname = res.getString(5);
				String u_tel = res.getString(6);
				String u_add = res.getString(7);
				String u_email = res.getString(8);
				int u_status = res.getInt(9);
				
				UserClientPOJO pojo = new UserClientPOJO(u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status);
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
	
	//按名字查找
	public List<UserClientPOJO> findByName(String uName) {
		List<UserClientPOJO> list = new ArrayList<UserClientPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status from userclient where u_name like ?";
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, "%" + uName + "%");
			res = pstat.executeQuery();
			
			while(res.next()){
				int u_id = res.getInt(1);
				String u_name = res.getString(2);
				String u_psw = res.getString(3);
				String u_num = res.getString(4);
				String u_rname = res.getString(5);
				String u_tel = res.getString(6);
				String u_add = res.getString(7);
				String u_email = res.getString(8);
				int u_status = res.getInt(9);
				
				UserClientPOJO pojo = new UserClientPOJO(u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status);
				list.add(pojo);
			}
		}catch (Exception e) {
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
	
	//按页数查找
	public List<UserClientPOJO> findByNum(int num) {
		List<UserClientPOJO> list = new ArrayList<UserClientPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select * from (select rownum no,u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status from userclient where rownum < " + (num*10+1) + ") where no > " + ((num-1)*10);
			pstat = this.conn.prepareStatement(sql);

			res = pstat.executeQuery();
			while(res.next()){
				int u_id = res.getInt(2);
				String u_name = res.getString(3);
				String u_psw = res.getString(4);
				String u_num = res.getString(5);
				String u_rname = res.getString(6);
				String u_tel = res.getString(7);
				String u_add = res.getString(8);
				String u_email = res.getString(9);
				int u_status = res.getInt(10);
				
				UserClientPOJO pojo = new UserClientPOJO(u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status);
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
	//按名字密码查找
	public List<UserClientPOJO> findByNP(String uNum, String uPsw) {
		List<UserClientPOJO> list = new ArrayList<UserClientPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status from userclient where u_num = '" + uNum + "' and u_psw = '" + uPsw + "'";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			System.out.println(sql);
			while(res.next()){
				int u_id = res.getInt(1);
				String u_name = res.getString(2);
				String u_psw = res.getString(3);
				String u_num = res.getString(4);
				String u_rname = res.getString(5);
				String u_tel = res.getString(6);
				String u_add = res.getString(7);
				String u_email = res.getString(8);
				int u_status = res.getInt(9);
				
				UserClientPOJO pojo = new UserClientPOJO(u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status);
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
	//按账号查找
	public List<UserClientPOJO> findByUNum(String uNum) {
		List<UserClientPOJO> list = new ArrayList<UserClientPOJO>();
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {
			String sql = "select u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status from userclient where u_num = '" + uNum + "'";
			pstat = this.conn.prepareStatement(sql);
			res = pstat.executeQuery();
			while(res.next()){
				int u_id = res.getInt(1);
				String u_name = res.getString(2);
				String u_psw = res.getString(3);
				String u_num = res.getString(4);
				String u_rname = res.getString(5);
				String u_tel = res.getString(6);
				String u_add = res.getString(7);
				String u_email = res.getString(8);
				int u_status = res.getInt(9);
				
				UserClientPOJO pojo = new UserClientPOJO(u_id,u_name,u_psw,u_num,u_rname,u_tel,u_add,u_email,u_status);
				list.add(pojo);
			}
		}catch (Exception e) {
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
	//查找uId最大值
	public int findMax() {
		int max = 0;
		PreparedStatement pstat = null;
		ResultSet res = null;
		try {

			String sql = "select max(u_id) from userclient";
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
	
	//注册
	public boolean doReg(UserClientPOJO pojo) {
		boolean bool = false;
		PreparedStatement pstat = null;
		try {
			String sql = "insert into userclient (u_id,u_psw,u_num,u_status) values(?,?,?,?)";
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1,pojo.getuId());
			pstat.setString(2,pojo.getuPsw());
			pstat.setString(3,pojo.getuNum());
			pstat.setInt(4,pojo.getuStatus());
			
			
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
}

