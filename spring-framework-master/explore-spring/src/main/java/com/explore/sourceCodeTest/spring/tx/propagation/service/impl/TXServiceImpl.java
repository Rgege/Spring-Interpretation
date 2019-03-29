package com.explore.sourceCodeTest.spring.tx.propagation.service.impl;

import com.explore.sourceCodeTest.spring.tx.propagation.UserA;
import com.explore.sourceCodeTest.spring.tx.propagation.UserB;
import com.explore.sourceCodeTest.spring.tx.propagation.service.AUserService;
import com.explore.sourceCodeTest.spring.tx.propagation.service.BUserService;
import com.explore.sourceCodeTest.spring.tx.propagation.service.TXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TXServiceImpl implements TXService {

	@Autowired
	private AUserService aUserService;
	@Autowired
	private BUserService bUserService;

	@Override
	public void notransaction_exception_required_required() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequired(bUser);

		throw new RuntimeException();
	}

	@Override
	public void notransaction_required_required_exception() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequiredException(bUser);
	}

	@Override
	public void transaction_exception_required_required() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequired(bUser);

		throw new RuntimeException();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequiredException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception_try() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		try {
			bUserService.addRequiredException(bUser);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}

	@Override
	public void notransaction_exception_requiresNew_requiresNew() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequiresNew(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequiresNew(bUser);
		throw new RuntimeException();
	}

	@Override
	public void notransaction_requiresNew_requiresNew_exception() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequiresNew(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequiresNewException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_requiresNew_requiresNew() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequiresNew(bUser);

		UserB user3 = new UserB();
		user3.setName("王五");
		bUserService.addRequiresNew(user3);
		throw new RuntimeException();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequiresNew(bUser);

		UserB user3 = new UserB();
		user3.setName("王五");
		bUserService.addRequiresNewException(user3);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception_try() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addRequiresNew(bUser);
		UserB user3 = new UserB();
		user3.setName("王五");
		try {
			bUserService.addRequiresNewException(user3);
		} catch (Exception e) {
			System.out.println("回滚");
		}
	}

	@Override
	public void notransaction_exception_nested_nested() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addNested(bUser);
		throw new RuntimeException();
	}

	@Override
	public void notransaction_nested_nested_exception() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addNestedException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_nested_nested() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addNested(bUser);
		throw new RuntimeException();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_nested_nested_exception() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		bUserService.addNestedException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_nested_nested_exception_try() {
		UserA aUser = new UserA();
		aUser.setName("张三");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("李四");
		try {
			bUserService.addNestedException(bUser);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}
}
