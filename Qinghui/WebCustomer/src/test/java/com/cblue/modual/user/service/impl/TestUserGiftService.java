package com.cblue.modual.user.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.modual.user.service.UserGiftService;
import com.cblue.modual.user.service.UserInfoService;

public class TestUserGiftService {
	private UserGiftService userGiftServiceImpl;
	@Before
	public void setUpBeforeClass(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		userGiftServiceImpl = (UserGiftService)ac.getBean("userGiftServiceImpl");
		//UserInfoService userInfoService = new UserInfoServiceImpl();
	}
	@Test
	public void testSave(){
//		for(int i=0;i<10;i++){
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUser_name("aaa"+i);
//		userInfo.setUser_password("bbb"+i);
//		userInfoService.save(userInfo);
//		}
	}
}
