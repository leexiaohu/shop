package com.shop.DAO;

import java.util.List;

import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;


public interface CommodityHistoryDAO {
	public boolean doIns(CommodityHistoryPOJO pojo);//����
	public boolean doDel(int hId);//ɾ��
	public boolean doUpd(CommodityHistoryPOJO pojo);//�޸�
	public List<CommodityHistoryPOJO> findAll();//����ȫ��
	public List<CommodityHistoryPOJO> findByNum(String cNum);//��cNum����
	public boolean doInC(int hinc,String cnum);//����
	public int findMax();//����hId���ֵs
	public List<CommodityHistoryPOJO> findByYNum(int num);//��ҳ������
	public List<CommodityHistoryPOJO> findByName(String cName);//�����ֲ���
	public List<CommodityHistoryPOJO> findT();//������������
}
