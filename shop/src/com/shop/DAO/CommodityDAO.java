package com.shop.DAO;

import java.util.List;

import com.shop.POJO.CommodityHistoryPOJO;
import com.shop.POJO.CommodityPOJO;


public interface CommodityDAO {
	public boolean doIns(CommodityPOJO pojo);//����
	public boolean doDel(int cId);//ɾ��
	public boolean doUpd(CommodityPOJO pojo);//�޸�
	public List<CommodityPOJO> findAll();//����ȫ��
	public List<CommodityPOJO> findById(int cId);//��Id����
	public List<CommodityPOJO> findByName(String cName);//�����ֲ���
	public List<CommodityPOJO> findByNum(int num);//��ҳ������
	public int findMax();//����cId���ֵ
	public List<CommodityPOJO> findBycNum(String cNum);//��cNum����
}
