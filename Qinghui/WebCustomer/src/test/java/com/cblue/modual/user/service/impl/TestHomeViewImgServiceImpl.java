package com.cblue.modual.user.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.modual.user.service.HomeViewImgService;
import com.cblue.modual.user.service.UserTicklingService;

public class TestHomeViewImgServiceImpl {
	private HomeViewImgService homeViewImgService;
	@Before
	public void setUpBeforeClass(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		homeViewImgService = (HomeViewImgService)ac.getBean("homeViewImgServiceImpl");
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