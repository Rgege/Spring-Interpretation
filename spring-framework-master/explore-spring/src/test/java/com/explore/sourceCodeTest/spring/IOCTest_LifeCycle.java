package com.explore.sourceCodeTest.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.explore.sourceCodeTest.spring.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {

	@Test
	public void test01(){
		//1、创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成...");

		//applicationContext.getBean("car");
		//关闭容器
		applicationContext.close();
	}

}