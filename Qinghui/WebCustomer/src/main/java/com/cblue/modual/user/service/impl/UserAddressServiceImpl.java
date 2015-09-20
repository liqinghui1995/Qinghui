package com.cblue.modual.user.service.impl;

import org.springframework.stereotype.Service;
import com.cblue.modual.user.bean.UserAddress;
import com.cblue.modual.user.service.UserAddressService;
import com.cblue.webkernel.service.DaoSupport;

@Service
public class UserAddressServiceImpl extends DaoSupport<UserAddress> implements
		UserAddressService{

}
