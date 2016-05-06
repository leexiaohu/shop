package com.shop.DAO;

import java.util.List;
import com.shop.POJO.AdminPOJO;


public interface AdminDAO {
	public boolean doIns(AdminPOJO pojo);//新增
	public boolean doDel(int aId);//删除
	public boolean doUpd(AdminPOJO pojo);//修改
	public List<AdminPOJO> findAll();//查找全部
	public List<AdminPOJO> findByName(String aName);//按名字查找
	public List<AdminPOJO> findByNP(String aName,String aPsw);//按名字、密码查找
}
