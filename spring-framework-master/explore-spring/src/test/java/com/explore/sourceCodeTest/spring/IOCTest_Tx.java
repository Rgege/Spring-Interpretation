package com.explore.sourceCodeTest.spring;

import com.explore.sourceCodeTest.spring.tx.propagation.service.AUserService;
import com.explore.sourceCodeTest.spring.tx.propagation.service.TXService;
import org.junit.After;
import org.junit.Before;
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

import java.util.HashMap;
import java.util.Map;

public class IOCTest_Tx {

	private AnnotationConfigApplicationContext applicationContext;

	@Before
	public void before(){
		this.applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
	}
	
	@Test
	public void test01(){
		UserService userService = applicationContext.getBean(UserService.class);
		try {
			userService.function1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPropagation(){
		TXService txService= applicationContext.getBean(TXService.class);

//		txService.notransaction_exception_required_required();
		txService.notransaction_required_required_exception();
	}

	@Test
	public void test(){
		TXService txService=applicationContext.getBean(TXService.class);
		txService.test();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("qq",123456);
		map.get("qq");
	}

	@After
	public void after(){
		this.applicationContext.close();
	}
}
