package com.cblue.modual.user.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cblue.modual.nourishmentfood.bean.NourishmentFood;
import com.cblue.modual.orderinfo.bean.OrderInfo;
import com.cblue.modual.orderinfo.service.OrderInfoService;
import com.cblue.webkernel.bean.QueryResult;

public class TestOrderInfoServiceImpl {
	private OrderInfoService orderInfoService;
	@Before
	public void setUpBeforeClass(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		orderInfoService = (OrderInfoService) ac.getBean("orderInfoServiceImpl");
		//UserInfoService userInfoService = new UserInfoServiceImpl();
	}
	@Test
	public void testSave(){
//		for(int i=0;i<10;i++){
//			OrderInfo orderInfo = new OrderInfo();
//			orderInfo.setOrder_info("aaa"+i);
//			orderInfo.setOrder_money("bbb"+i);
//			orderInfoService.save(orderInfo);
//			}

	}
	@Test
	public void testFind(){
		QueryResult queryResult = orderInfoService.getScrollData();
		List<OrderInfo> list = queryResult.getResultlist();
		for(OrderInfo orderInfo:list){
			System.out.println(orderInfo);
	}
	}






}

