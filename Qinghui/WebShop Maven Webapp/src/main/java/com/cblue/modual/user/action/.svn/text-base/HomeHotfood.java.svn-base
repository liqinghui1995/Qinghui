package com.cblue.modual.user.action;

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
import com.cblue.modual.orderfood.bean.DiningRoom;
import com.cblue.modual.orderfood.service.DiningRoomService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;

public class HomeHotfood extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		String address = req.getParameter("address");
		String addressstr = new String(address.getBytes("ISO-8859-1"), "UTF-8");
		resp.setCharacterEncoding("GBK");
//		System.out.println(address);
		System.out.println(addressstr);
//		String dindingRoom = req.getParameter("id");
		DiningRoomService diningRoomService = (DiningRoomService)Controller.getDaoImple("diningRoomServiceImpl");
		QueryResult<DiningRoom> queryResult = diningRoomService.getScrollData(0, 10, "DiningRoomAddress LIKE '%"+addressstr+"%'", new Object[]{});
		List<DiningRoom> list = queryResult.getResultlist();
		String str = "";
		for(int i=0;i<list.size();i++){
			if(i>0&&i<list.size()){
				str+=",";
			}
			str+=String.valueOf(list.get(i).getId());
		}
		System.out.println(str);
		if(str!=null&&!str.equals("")){
			NourishmentFoodService nourishmentFoodService = (NourishmentFoodService)Controller.getDaoImple("nourishmentFoodServiceImpl");
			QueryResult<NourishmentFood> nourishmentFoods =  nourishmentFoodService.getScrollData(0, 10, "shop_id in("+str+")",new Object[]{});
			List<NourishmentFood> foodList = nourishmentFoods.getResultlist();
			HotFoodBean hotFood = new HotFoodBean();
			hotFood.setFoodList(foodList);
			hotFood.setDiningRoomList(list);
			String jsonStr = FastJsonUtils.createJsonString(hotFood);
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
		}
	}
}
