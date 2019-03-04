package com.explore.sourceCodeTest.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void insertUser(){
		for (int i = 0; i <10 ; i++) {
			String username = UUID.randomUUID().toString().substring(0, 5);
			userDao.insert(username,i);
		}
		//otherDao.other();xxx
		System.out.println("插入完成...");
		throw new RuntimeException("==============手动抛个异常，测试事物回滚==============");
	}

}
