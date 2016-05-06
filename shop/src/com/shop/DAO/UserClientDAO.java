package com.shop.DAO;

import java.util.List;

import com.shop.POJO.AdminPOJO;
import com.shop.POJO.CommodityPOJO;
import com.shop.POJO.UserClientPOJO;

public interface UserClientDAO {
	public boolean doIns(UserClientPOJO pojo);//����
	public boolean doDel(int uId);//ɾ��
	public boolean doUpd(UserClientPOJO pojo);//�޸�
	public List<UserClientPOJO> findAll();//����ȫ��
	public List<UserClientPOJO> findByName(String uName);//�����ֲ���
	public List<UserClientPOJO> findByNum(int num);//��ҳ������
	public List<UserClientPOJO> findByNP(String uNum,String uPsw);//�����֡��������
	public List<UserClientPOJO> findByUNum(String uNum);//���˺Ų���
	public int findMax();//����bId���ֵ
	public boolean doReg(UserClientPOJO pojo);//ע��
}
