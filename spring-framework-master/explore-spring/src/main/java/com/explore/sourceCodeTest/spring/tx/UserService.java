package com.explore.sourceCodeTest.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void function1() throws Exception {
		userDao.insert("function1",20);
		try {
			function2();
		} catch (Exception e) {

//			throw e;
		}
//		throw new RuntimeException("==============手动抛个异常，测试事物回滚==============");
	}

	@Transactional
	public void function2() {
		userDao.insert("function2",20);
//		throw new RuntimeException("==============function1 抛出异常==============");
		String s=null;
		s.length();
	}
}
