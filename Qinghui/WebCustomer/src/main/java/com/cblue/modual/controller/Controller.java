package com.cblue.modual.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Controller {
	
	public static Object getDaoImple(String className){
		 ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
		 return ac.getBean(className);
	}

}
