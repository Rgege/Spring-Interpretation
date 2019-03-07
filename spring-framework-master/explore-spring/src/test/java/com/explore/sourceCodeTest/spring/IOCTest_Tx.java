package com.explore.sourceCodeTest.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.explore.sourceCodeTest.spring.aop.MathCalculator;
import com.explore.sourceCodeTest.spring.bean.Boss;
import com.explore.sourceCodeTest.spring.bean.Car;
import com.explore.sourceCodeTest.spring.bean.Color;
import com.explore.sourceCodeTest.spring.bean.Red;
import com.explore.sourceCodeTest.spring.config.MainConfigOfAOP;
import com.explore.sourceCodeTest.spring.config.MainConifgOfAutowired;
import com.explore.sourceCodeTest.spring.dao.BookDao;
import com.explore.sourceCodeTest.spring.service.BookService;
import com.explore.sourceCodeTest.spring.tx.TxConfig;
import com.explore.sourceCodeTest.spring.tx.UserService;

public class IOCTest_Tx {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(TxConfig.class);
	
		UserService userService = applicationContext.getBean(UserService.class);

		try {
			userService.function1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		applicationContext.close();
	}

}
