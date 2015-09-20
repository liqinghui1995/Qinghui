package com.cblue.modual.user.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cblue.modual.user.bean.UserInfo;
import com.cblue.modual.user.service.UserInfoService;
import com.cblue.webkernel.bean.QueryResult;




public class TestUserInfoServiceImpl {

	private UserInfoService userInfoService;
	@Before
	public void setUpBeforeClass(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		userInfoService = (UserInfoService)ac.getBean("userInfoServiceImpl");
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
	
	@Test
	public void testFind(){
		QueryResult queryResult = userInfoService.getScrollData(1, 5);
		List<UserInfo> list = queryResult.getResultlist();
		for(UserInfo userInfo:list){
			System.out.println(userInfo);
		}
	}
	
	
	
}
