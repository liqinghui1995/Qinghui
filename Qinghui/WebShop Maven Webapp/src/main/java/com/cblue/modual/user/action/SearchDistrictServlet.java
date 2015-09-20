package com.cblue.modual.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.user.bean.SearchDistrict;
import com.cblue.modual.user.service.SearchDistrictService;
import com.cblue.webkernel.bean.QueryResult;

public class SearchDistrictServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SearchDistrictService searchDistrictService = (SearchDistrictService) Controller.getDaoImple("searchDistrictServiceImpl");
		QueryResult<SearchDistrict> queryResult = searchDistrictService.getScrollData();
		List<SearchDistrict> list = queryResult.getResultlist();
	}
}
