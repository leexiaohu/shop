package com.shop.DAO;

import java.util.List;
import com.shop.POJO.FindsFlowPOJO;

public interface FindsFlowDAO {
	public boolean doIns(FindsFlowPOJO pojo);//新增
	public List<FindsFlowPOJO> findByUName(String uName);//按用户名查找
	public int findMax();//查找费fId最大值
	public List<FindsFlowPOJO> findIn(String username);//查找总收入
	public List<FindsFlowPOJO> finout(String username);//查找总收入
}
