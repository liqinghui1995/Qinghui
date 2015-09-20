package com.cblue.modual.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.user.bean.HomeViewImg;
import com.cblue.modual.user.service.HomeViewImgService;
import com.cblue.modual.user.service.UserInfoService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;

public class HomeViewPagerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("GBK");
		HomeViewImgService	homeViewImgService = (HomeViewImgService)Controller.getDaoImple("homeViewImgServiceImpl");
		QueryResult<HomeViewImg> queryResult = homeViewImgService.getScrollData();
		List<HomeViewImg> list = queryResult.getResultlist();
		String jsonstr = FastJsonUtils.createJsonString(list);
		PrintWriter out = resp.getWriter();
		out.write(jsonstr);
		out.close();
	}
}
