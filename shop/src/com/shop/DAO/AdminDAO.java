package com.shop.DAO;

import java.util.List;
import com.shop.POJO.AdminPOJO;


public interface AdminDAO {
	public boolean doIns(AdminPOJO pojo);//����
	public boolean doDel(int aId);//ɾ��
	public boolean doUpd(AdminPOJO pojo);//�޸�
	public List<AdminPOJO> findAll();//����ȫ��
	public List<AdminPOJO> findByName(String aName);//�����ֲ���
	public List<AdminPOJO> findByNP(String aName,String aPsw);//�����֡��������
}
