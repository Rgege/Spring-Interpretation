package com.explore.sourceCodeTest.spring.tx.propagation.service.impl;

import com.explore.sourceCodeTest.spring.tx.mapper.AMapper;
import com.explore.sourceCodeTest.spring.tx.propagation.UserA;
import com.explore.sourceCodeTest.spring.tx.propagation.dao.ADao;
import com.explore.sourceCodeTest.spring.tx.propagation.service.AUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AUserServiceImpl implements AUserService {
	private static final Logger LOGGER=LoggerFactory.getLogger(AUserServiceImpl.class);
	@Autowired
	private AMapper aDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(UserA user) {
		LOGGER.info("===================AUser userName:"+user.getName());
		aDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(UserA user) {
		LOGGER.info("===================AUser userName:"+user.getName());
		aDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(UserA user) {
		LOGGER.info("===================AUser userName:"+user.getName());
		aDao.insert(user);
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public void insert(UserA user) {
		aDao.insert(user);
//		throw new RuntimeException("=========================================抛异常");
	}
}
