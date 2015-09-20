package com.cblue.modual.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.user.bean.UserAddress;
import com.cblue.modual.user.bean.UserGift;
import com.cblue.modual.user.bean.UserGiftRecord;
import com.cblue.modual.user.bean.UserInfo;
import com.cblue.modual.user.bean.UserTickling;
import com.cblue.modual.user.service.UserAddressService;
import com.cblue.modual.user.service.UserGiftRecordService;
import com.cblue.modual.user.service.UserGiftService;
import com.cblue.modual.user.service.UserInfoService;
import com.cblue.modual.user.service.UserTicklingService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;

public class UsersServlet extends HttpServlet{
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
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String nickname = req.getParameter("nickname");
		String userid = req.getParameter("userid");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String coin = req.getParameter("coin");
		String record = req.getParameter("record");
		String tickling = req.getParameter("tickling");
		String contact = req.getParameter("contact");
		String firstindex = req.getParameter("firstindex");
		String maxresult = req.getParameter("maxresult");
		String giftid = req.getParameter("giftid");
		if(method == null&&method.equals("")){
			return;
		}

		if(method.equals("login")){
			try {
				login(userName, password, req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(method.equals("register")){
			try {
				register(userName, password, req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(method.equals("changenickname")){
			try {
				changeNickName(Integer.parseInt(userid),userName, password, nickname, address, phone, Integer.parseInt(coin), Integer.parseInt(record), req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		if(method.equals("addaddress")){
			try {
				addaddress(Integer.parseInt(userid), address, req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(method.equals("queryaddress")){
			try {
				queryAddress(Integer.parseInt(userid), Integer.parseInt(firstindex), Integer.parseInt(maxresult), req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		if(method.equals("tickling")){
			try {
				Tickling(Integer.parseInt(userid), tickling, contact, req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		if(method.equals("giftrecord")){
			try {
				giftRecord(Integer.parseInt(userid), Integer.parseInt(firstindex), Integer.parseInt(maxresult), req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(method.equals("convert")){
			try {
				convert(Integer.parseInt(userid), Integer.parseInt(giftid), req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(method.equals("gift")){
			try {
				Gift(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void login(String userName,String password,HttpServletRequest req, HttpServletResponse resp) throws Exception{
		UserInfoService	userInfoService = (UserInfoService)Controller.getDaoImple("userInfoServiceImpl");
		QueryResult<UserInfo> queryResult = userInfoService.getScrollData(0, 1, "user_name = ? and user_password = ?", new Object[]{userName,password});
		QueryResult<UserInfo> passwordResult = userInfoService.getScrollData(0, 1, "user_name = ? ", new Object[]{userName});
		QueryResult<UserInfo> userResult = userInfoService.getScrollData(0, 1, "user_password = ? ", new Object[]{password});
		List<UserInfo> list = queryResult.getResultlist();
		List<UserInfo> pwdList = passwordResult.getResultlist();
		List<UserInfo> userList = userResult.getResultlist();
		if(userList.size()==1&&list.size()==0){
			String jsonStr = "用户名不存在";
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
		}
		if(pwdList.size()==1&&list.size()==0){
			String jsonStr = "密码错误";
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
		}
		if(list.size()!=0){
			if(pwdList.get(0).getUser_password().equals(password)){
				String jsonStr = FastJsonUtils.createJsonString(list);
				PrintWriter out = resp.getWriter();
				out.print(jsonStr);
				out.close();
			}else{
				String jsonStr = "密码错误";
				PrintWriter out = resp.getWriter();
				out.print(jsonStr);
				out.close();
			}
		}
	}
	/**
	 * 注册
	 * @param userName
	 * @param password
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void register(String userName,String password,
			HttpServletRequest req, HttpServletResponse resp) throws Exception{
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_name(userName);
		userInfo.setUser_password(password);
		userInfo.setUser_nickname(userName);

		UserInfoService userInfoService = (UserInfoService) Controller.getDaoImple("userInfoServiceImpl");
		QueryResult<UserInfo> queryResult = userInfoService.getScrollData(0, 1, "user_name = ?", new Object[]{userName});
		List<UserInfo> list = queryResult.getResultlist();
		if(list.size()<=0){
			userInfoService.save(userInfo);
			String jsonStr = FastJsonUtils.createJsonString(userInfo);
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
		}else{
			String jsonStr = "用户名已经存在";
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
		}


	}
	/**
	 * 修改昵称
	 * @param nickname
	 * @param password
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void changeNickName(int userid,String userName,String password,String nickname,String address,
			String phone,int coin,int record,
			HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_id(userid);
		userInfo.setUser_name(userName);
		userInfo.setUser_nickname(nickname);
		userInfo.setUser_coin(coin);
		userInfo.setUser_password(password);
		userInfo.setUser_record(record);
		UserInfoService userInfoService = (UserInfoService) Controller.getDaoImple("userInfoServiceImpl");
		userInfoService.update(userInfo);
		String jsonStr = FastJsonUtils.createJsonString(userInfo);
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
		out.close();
	}
	/**
	 * 添加新地址
	 * @param userid
	 * @param address
	 * @throws IOException 
	 */
	public void addaddress(int userid,String address,HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserAddress userAddress = new UserAddress();
		userAddress.setUserid(userid);
		userAddress.setAddress(address);
		UserAddressService userAddressService = (UserAddressService) Controller.getDaoImple("userAddressServiceImpl");
		userAddressService.save(userAddress);
		String jsonStr = FastJsonUtils.createJsonString(userAddress);
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
		out.close();
	}
	/**
	 * 查询地址
	 * @param userid
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void queryAddress(int userid,int min,int max,HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserAddressService userAddressService = (UserAddressService) Controller.getDaoImple("userAddressServiceImpl");
		QueryResult<UserAddress> queryResult = userAddressService.getScrollData(min, max, "userid = ?", new Object[]{userid});
		List<UserAddress> addresslist = queryResult.getResultlist();
		if(addresslist.size()==0){
			String jsonStr = "没有此用户信息";
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
		}else{
			String jsonStr = FastJsonUtils.createJsonString(addresslist);
			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.close();
		}
	}
	/**
	 * 添加用户反馈
	 * @param userid
	 * @param tickling
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void Tickling(int userid,String tickling,String contact,HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserTickling userTickling = new UserTickling();
		userTickling.setUserid(userid);
		userTickling.setContent(tickling);
		userTickling.setContact(contact);
		UserTicklingService userTicklingService = (UserTicklingService) Controller.getDaoImple("userTicklingServiceImpl");
		userTicklingService.save(userTickling);
		String jsonStr = FastJsonUtils.createJsonString(userTickling);
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
		out.close();
	}
	/**
	 * 礼品站
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void Gift(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserGiftService userGiftService = (UserGiftService) Controller.getDaoImple("userGiftServiceImpl");
		QueryResult<UserGift> queryResult = userGiftService.getScrollData();
		List<UserGift> list = queryResult.getResultlist();
		String jsonStr = FastJsonUtils.createJsonString(list);
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
		out.close();
	}
	/**
	 * 查询记录
	 * @param userid
	 * @param firstindex
	 * @param maxresult
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void giftRecord(int userid,int firstindex,int maxresult,HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserGiftRecordService userGiftRecordService = (UserGiftRecordService) Controller.getDaoImple("userGiftRecordServiceImpl");
		QueryResult<UserGiftRecord> queryResult = userGiftRecordService.getScrollData(firstindex, maxresult, "userid = ?", new Object[]{userid});
		List<UserGiftRecord> list = queryResult.getResultlist();
		UserGiftService userGiftService = (UserGiftService) Controller.getDaoImple("userGiftServiceImpl");
		String str = "";
		for(int i=0;i<list.size();i++){

			if(i>0&&i<list.size()){
				str+=",";
			}
			str+=String.valueOf(list.get(i).getGiftid());
		}
		QueryResult<UserGift> userqueryResult = userGiftService.getScrollData(firstindex, maxresult, "id in ("+str+")",new Object[]{});
		List<UserGift> userList = userqueryResult.getResultlist();
		System.out.println(userList.toString());
		String jsonStr = FastJsonUtils.createJsonString(userList);
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
		out.close();
	}

	public void convert(int userid,int giftid,HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserGiftRecord userGiftRecord = new UserGiftRecord();
		userGiftRecord.setUserid(userid);
		userGiftRecord.setGiftid(giftid);
		UserGiftRecordService userGiftRecordService = (UserGiftRecordService) Controller.getDaoImple("userGiftRecordServiceImpl");
		userGiftRecordService.save(userGiftRecord);
		String jsonStr = FastJsonUtils.createJsonString(userGiftRecord);
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
		out.close();
	}
}
