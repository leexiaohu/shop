package com.shop.PUB;

import java.util.List;

import com.shop.Factory.ShopDAOFactory;
import com.shop.POJO.FindsFlowPOJO;
/***
 * 
 * ≤È—Ø’Àªß”‡∂Ó
 * @author Administrator
 *
 */
public class FindBalance {
	public static int findbl(String username){
		int sum = 0;
		int in = 0;
		int out = 0;
		List<FindsFlowPOJO> list = ShopDAOFactory.getFindsFlowDAOInsancet().findIn(username);
		List<FindsFlowPOJO> list1 = ShopDAOFactory.getFindsFlowDAOInsancet().finout(username);
		
		for(int i=0;i<list.size();i++){
			in += list.get(i).getfSum();
		}
		
		for(int i=0;i<list1.size();i++){
			out += list1.get(i).getfSum();
		}
		sum = in - out;
		
		return sum;
		
	}
}
