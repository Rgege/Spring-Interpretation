package com.explore.sourceCodeTest.spring.tx.propagation.service.impl;

import com.explore.sourceCodeTest.spring.tx.propagation.UserB;
import com.explore.sourceCodeTest.spring.tx.propagation.dao.BDao;
import com.explore.sourceCodeTest.spring.tx.propagation.service.BUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BUserServiceImpl implements BUserService {
	@Autowired
	private BDao bDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(UserB user) {
		bDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequiredException(UserB user) {
		bDao.insert(user);
		throw new RuntimeException();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(UserB user) {
		bDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNewException(UserB user) {
		bDao.insert(user);
		throw new RuntimeException();
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(UserB user) {
		bDao.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNestedException(UserB user) {
		bDao.insert(user);
		throw new RuntimeException();
	}
}
