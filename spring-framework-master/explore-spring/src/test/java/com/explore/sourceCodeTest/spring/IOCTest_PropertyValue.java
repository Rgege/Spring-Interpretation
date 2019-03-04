package com.explore.sourceCodeTest.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.explore.sourceCodeTest.spring.bean.Person;
import com.explore.sourceCodeTest.spring.config.MainConfigOfLifeCycle;
import com.explore.sourceCodeTest.spring.config.MainConfigOfPropertyValues;

public class IOCTest_PropertyValue {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	@Test
	public void test01(){
		printBeans(applicationContext);
		System.out.println("=============");
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		applicationContext.close();
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}