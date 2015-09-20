package com.cblue.modual.orderinfo.service.impl;


import org.springframework.stereotype.Service;

import com.cblue.modual.orderinfo.bean.OrderInfo;
import com.cblue.modual.orderinfo.service.OrderInfoService;
import com.cblue.webkernel.service.DaoSupport;
@Service 
public class OrderInfoServiceImpl extends DaoSupport<OrderInfo> implements OrderInfoService{

}
