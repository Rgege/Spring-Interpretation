package com.explore.sourceCodeTest.spring.tx.propagation.service.impl;

import com.explore.sourceCodeTest.spring.tx.mapper.BMapper;
import com.explore.sourceCodeTest.spring.tx.propagation.UserB;
import com.explore.sourceCodeTest.spring.tx.propagation.dao.BDao;
import com.explore.sourceCodeTest.spring.tx.propagation.service.BUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BUserServiceImpl implements BUserService {
	private static final Logger LOGGER=LoggerFactory.getLogger(BUserServiceImpl.class);

	@Autowired
	private BMapper bDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(UserB user) {
		LOGGER.info("===================BUser userName:"+user.getName());
		bDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequiredException(UserB user) {
		LOGGER.info("===================BUser userName:"+user.getName());
		bDao.insert(user);
		throw new RuntimeException("====================被调用的方法抛出异常========================");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(UserB user) {
		LOGGER.info("===================BUser userName:"+user.getName());
		bDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNewException(UserB user) {
		LOGGER.info("===================BUser userName:"+user.getName());
		bDao.insert(user);
		throw new RuntimeException("====================被调用的方法抛出异常========================");
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(UserB user) {
		LOGGER.info("===================BUser userName:"+user.getName());
		bDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNestedException(UserB user) {
		LOGGER.info("===================BUser userName:"+user.getName());
		bDao.insert(user);
		throw new RuntimeException("====================被调用的方法抛出异常========================");
	}
}
