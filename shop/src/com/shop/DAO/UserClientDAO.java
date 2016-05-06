package com.shop.DAO;

import java.util.List;

import com.shop.POJO.AdminPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.POJO.UserClientPOJO;

public interface UserClientDAO {
	public boolean doIns(UserClientPOJO pojo);//新增
	public boolean doDel(int uId);//删除
	public boolean doUpd(UserClientPOJO pojo);//修改
	public List<UserClientPOJO> findAll();//查找全部
	public List<UserClientPOJO> findByName(String uName);//按名字查找
	public List<UserClientPOJO> findByNum(int num);//按页数查找
	public List<UserClientPOJO> findByNP(String uNum,String uPsw);//按名字、密码查找
	public List<UserClientPOJO> findByUNum(String uNum);//按账号查找
	public int findMax();//查找bId最大值
	public boolean doReg(UserClientPOJO pojo);//注册
}
