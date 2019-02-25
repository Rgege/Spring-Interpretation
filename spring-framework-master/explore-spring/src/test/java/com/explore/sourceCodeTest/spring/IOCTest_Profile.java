package com.explore.sourceCodeTest.spring;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.explore.sourceCodeTest.spring.bean.Boss;
import com.explore.sourceCodeTest.spring.bean.Car;
import com.explore.sourceCodeTest.spring.bean.Color;
import com.explore.sourceCodeTest.spring.bean.Red;
import com.explore.sourceCodeTest.spring.bean.Yellow;
import com.explore.sourceCodeTest.spring.config.MainConfigOfProfile;
import com.explore.sourceCodeTest.spring.config.MainConifgOfAutowired;
import com.explore.sourceCodeTest.spring.dao.BookDao;
import com.explore.sourceCodeTest.spring.service.BookService;

public class IOCTest_Profile {

	//1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
	//2、代码的方式激活某种环境；
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		//1、创建一个applicationContext
		//2、设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("dev");
		//3、注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//4、启动刷新容器
		applicationContext.refresh();


		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}

		Yellow bean = applicationContext.getBean(Yellow.class);
		System.out.println(bean);
		applicationContext.close();
	}

}
