/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.explore.sourceCodeTest.beansSC;

import com.explore.sourceCodeTest.beansSC.support.AllenPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TestGetBean.
 *
 * @author xiong rui
 * @version 1.0.0
 **/
public class TestGetBean {


	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("support/Bean.xml");
//		AllenPojo pojo=(AllenPojo) context.getBean("allenPojo");

		ApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) applicationContext).scan("com.explore.sourceCodeTest.beansSC");
		String[] ss=applicationContext.getBeanDefinitionNames();
		for (String s:ss){
			System.out.println(s);
		}

		AllenPojo pojo= applicationContext.getBean(AllenPojo.class);
		pojo.t();
	}

}
