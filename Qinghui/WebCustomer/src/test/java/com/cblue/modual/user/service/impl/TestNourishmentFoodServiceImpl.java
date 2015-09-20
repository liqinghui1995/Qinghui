package com.cblue.modual.user.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.modual.nourishmentfood.bean.NourishmentFood;
import com.cblue.modual.nourishmetfood.service.NourishmentFoodService;
import com.cblue.modual.user.bean.UserInfo;
import com.cblue.webkernel.bean.QueryResult;

public class TestNourishmentFoodServiceImpl {
	
	private NourishmentFoodService nourishmentFoodService;
	@Before
	public void setUpBeforeClass(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		nourishmentFoodService = (NourishmentFoodService)ac.getBean("nourishmentFoodServiceImpl");
	}
	@Test
	public void testSave(){
//		NourishmentFood n = new NourishmentFood("", "", 2.00, 20, 1, "", 0);
//		nourishmentFoodService.save(n);
	}
	@Test
	public void testFind(){
		QueryResult queryResult = nourishmentFoodService.getScrollData();
		List<NourishmentFood> list = queryResult.getResultlist();
		for(NourishmentFood userInfo:list){
			System.out.println(userInfo);
		}
	}
}
