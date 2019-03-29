package com.explore.sourceCodeTest.spring.tx.propagation.service.impl;

import com.explore.sourceCodeTest.spring.tx.propagation.UserA;
import com.explore.sourceCodeTest.spring.tx.propagation.dao.ADao;
import com.explore.sourceCodeTest.spring.tx.propagation.service.AUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AUserServiceImpl implements AUserService {
	@Autowired
	private ADao aDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(UserA user) {
		aDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(UserA user) {
		aDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(UserA user) {
		aDao.insert(user);
	}
}
