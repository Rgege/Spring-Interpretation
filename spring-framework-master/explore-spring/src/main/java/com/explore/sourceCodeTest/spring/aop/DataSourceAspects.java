package com.explore.sourceCodeTest.spring.aop;

import com.explore.sourceCodeTest.spring.aop.annotation.DataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * AOP 多数据源管理
 */
@Aspect
public class DataSourceAspects {

	@Pointcut("@annotation(com.explore.sourceCodeTest.spring.aop.annotation.DataSource)")
	public void pointCut(){

	}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint){
		MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
		Method method=methodSignature.getMethod();
		DataSource dataSource=method.getDeclaredAnnotation(DataSource.class);
		String val=dataSource.value();
	}
}
