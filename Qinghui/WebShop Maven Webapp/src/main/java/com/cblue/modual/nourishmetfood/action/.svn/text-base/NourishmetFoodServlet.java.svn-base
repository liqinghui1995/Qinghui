package com.cblue.modual.nourishmetfood.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.nourishmentfood.bean.NourishmentFood;
import com.cblue.modual.nourishmetfood.service.NourishmentFoodService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;

public class NourishmetFoodServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String flag = req.getParameter("flag");
//		System.out.println(flag);
//		String flag ="1";
//		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("GBK");
		NourishmentFoodService nourishmentFoodService = (NourishmentFoodService)Controller.getDaoImple("nourishmentFoodServiceImpl");
		QueryResult<NourishmentFood> nourishmentFoods =  nourishmentFoodService.getScrollData(0, 20, "flag=?",new Object[]{flag});
		String jsonStr = FastJsonUtils.createJsonString(nourishmentFoods);
	    PrintWriter out = resp.getWriter();
	    out.print(jsonStr);
	    out.close();
	}
}
