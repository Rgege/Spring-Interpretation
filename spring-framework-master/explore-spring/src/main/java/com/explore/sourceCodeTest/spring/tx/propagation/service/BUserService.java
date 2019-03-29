package com.explore.sourceCodeTest.spring.tx.propagation.service;

import com.explore.sourceCodeTest.spring.tx.propagation.UserB;

public interface BUserService {


	void addRequired(UserB user);

	void addRequiredException(UserB user);

	void addRequiresNew(UserB user);

	void addRequiresNewException(UserB user);

	void addNested(UserB user);

	void addNestedException(UserB user);
}
