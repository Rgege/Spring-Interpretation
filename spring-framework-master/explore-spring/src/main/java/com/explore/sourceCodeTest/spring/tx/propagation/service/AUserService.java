package com.explore.sourceCodeTest.spring.tx.propagation.service;

import com.explore.sourceCodeTest.spring.tx.propagation.UserA;

public interface AUserService {

	void addRequired(UserA user);

	void addRequiresNew(UserA user);

	void addNested(UserA user);

	void insert(UserA user);
}
