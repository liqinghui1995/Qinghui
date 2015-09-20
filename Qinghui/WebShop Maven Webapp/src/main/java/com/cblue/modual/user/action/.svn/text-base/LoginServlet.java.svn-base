package com.cblue.modual.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.user.bean.UserInfo;
import com.cblue.modual.user.service.UserInfoService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("aaa");
		/* ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		 PrintWriter out = resp.getWriter();
		 UserInfoService	userInfoService = (UserInfoService)ac.getBean("userInfoServiceImpl");
	*/	
		String name = req.getParameter("name");
		System.out.println("name="+name);
		UserInfoService	userInfoService = (UserInfoService)Controller.getDaoImple("userInfoServiceImpl");
		QueryResult queryResult = userInfoService.getScrollData(1, 5);
			List<UserInfo> list = queryResult.getResultlist();
			String jsonStr = FastJsonUtils.createJsonString(list);
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
	}

}
