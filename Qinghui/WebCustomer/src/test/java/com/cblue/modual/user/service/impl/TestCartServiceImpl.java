package com.cblue.modual.user.service.impl;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.modual.cart.bean.Cart;
import com.cblue.modual.cart.service.CartService;
import com.cblue.webkernel.bean.QueryResult;



public class TestCartServiceImpl {
	private CartService cartService;

	@Before
	public void setUpBeforeClass() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:beans.xml");
		cartService = (CartService) ac.getBean("cartServiceImpl");
		// UserInfoService userInfoService = new UserInfoServiceImpl();
	}

	@Test
	public void testSave() {
//		 for(int i=0;i<10;i++){
//			 Cart cart = new Cart();
//			 cart.setCart_name("aaa"+i);
//			 cartService.save(cart);
//		 }

	}

	@Test
	public void testFind() {
		QueryResult queryResult = cartService.getScrollData();
		List<Cart> list = queryResult.getResultlist();
		for (Cart cart : list) {
			System.out.println(cart);
		}
	}

}
