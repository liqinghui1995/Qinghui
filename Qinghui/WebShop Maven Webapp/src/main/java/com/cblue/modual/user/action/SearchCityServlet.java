package com.cblue.modual.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.user.bean.SearchCity;
import com.cblue.modual.user.bean.SearchDistrict;
import com.cblue.modual.user.service.SearchCityService;
import com.cblue.modual.user.service.SearchDistrictService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;

public class SearchCityServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("GBK");
		String method = req.getParameter("method");
		String cityid = req.getParameter("id");
		String district = req.getParameter("district");
		String districtstr = "";
		if(district!=null){
			districtstr = new String(district.getBytes("ISO-8859-1"), "UTF-8");
		}
		String json = null;
		if(method.equals("city")){
			SearchCityService searchCityService = (SearchCityService) Controller.getDaoImple("searchCityServiceImpl");
			QueryResult<SearchCity> queryResult = searchCityService.getScrollData();
			List<SearchCity> list = queryResult.getResultlist();
			json = FastJsonUtils.createJsonString(list);
		}
		
		if(method.equals("district")){
			SearchDistrictService searchDistrictService = (SearchDistrictService) Controller.getDaoImple("searchDistrictServiceImpl");
			QueryResult<SearchDistrict> districtResult = searchDistrictService.getScrollData(0, 10, "cityid = ? and district like '%"+districtstr+"%'", new Object[]{Integer.parseInt(cityid)});
			List<SearchDistrict> districtlist = districtResult.getResultlist();
			json = FastJsonUtils.createJsonString(districtlist);
		}

		PrintWriter out = resp.getWriter();
		out.print(json);
		out.close();
		
	}
}