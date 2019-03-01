package com.explore.sourceCodeTest.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.explore.sourceCodeTest.spring.bean.Person;
import com.explore.sourceCodeTest.spring.config.MainConfig;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		try {
			Person bean = (Person)applicationContext.getBean("person");
			System.out.println(bean);
		} catch (BeansException e) {
			e.printStackTrace();
		}

		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : namesForType) {
			System.out.println(name);
		}
	
	}

}
