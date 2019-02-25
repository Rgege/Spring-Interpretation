package com.explore.sourceCodeTest.spring;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.explore.sourceCodeTest.spring.aop.MathCalculator;
import com.explore.sourceCodeTest.spring.bean.Boss;
import com.explore.sourceCodeTest.spring.bean.Car;
import com.explore.sourceCodeTest.spring.bean.Color;
import com.explore.sourceCodeTest.spring.bean.Red;
import com.explore.sourceCodeTest.spring.config.MainConfigOfAOP;
import com.explore.sourceCodeTest.spring.config.MainConifgOfAutowired;
import com.explore.sourceCodeTest.spring.dao.BookDao;
import com.explore.sourceCodeTest.spring.ext.ExtConfig;
import com.explore.sourceCodeTest.spring.service.BookService;

public class IOCTest_Ext {

	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);


		//发布事件；
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
		});

		applicationContext.close();
	}

}
