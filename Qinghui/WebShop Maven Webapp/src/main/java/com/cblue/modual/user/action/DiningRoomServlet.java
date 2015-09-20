package com.cblue.modual.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.orderfood.bean.DiningRoom;
import com.cblue.modual.orderfood.service.DiningRoomService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;

public class DiningRoomServlet extends HttpServlet {
	
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
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
//		String dindingRoom = req.getParameter("id");
		DiningRoomService diningRoomService = (DiningRoomService)Controller.getDaoImple("diningRoomServiceImpl");
//		QueryResult<DiningRoom> diningRooms =    diningRoomService.getScrollData(0, 1, "id=?",new Object[]{Integer.valueOf(dindingRoom)});
		QueryResult<DiningRoom> diningRooms =    diningRoomService.getScrollData();
		String jsonStr = FastJsonUtils.createJsonString(diningRooms);
	    PrintWriter out = resp.getWriter();
	    out.print(jsonStr);
	    out.close();
	}

}
