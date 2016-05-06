package com.shop.DAO;

import java.util.List;
import com.shop.POJO.FindsFlowPOJO;

public interface FindsFlowDAO {
	public boolean doIns(FindsFlowPOJO pojo);//����
	public List<FindsFlowPOJO> findByUName(String uName);//���û�������
	public int findMax();//���ҷ�fId���ֵ
	public List<FindsFlowPOJO> findIn(String username);//����������
	public List<FindsFlowPOJO> finout(String username);//����������
}
