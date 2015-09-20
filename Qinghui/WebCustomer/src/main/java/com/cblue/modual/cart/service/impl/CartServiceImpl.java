package com.cblue.modual.cart.service.impl;

import org.springframework.stereotype.Service;

import com.cblue.modual.cart.bean.Cart;
import com.cblue.modual.cart.service.CartService;
import com.cblue.webkernel.service.DaoSupport;

@Service 
public class CartServiceImpl extends DaoSupport<Cart> implements CartService{

}
