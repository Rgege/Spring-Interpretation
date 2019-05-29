package com.explore.sourceCodeTest.spring.tx.propagation.service.impl;

import com.explore.sourceCodeTest.spring.tx.mapper.AMapper;
import com.explore.sourceCodeTest.spring.tx.mapper.BMapper;
import com.explore.sourceCodeTest.spring.tx.propagation.UserA;
import com.explore.sourceCodeTest.spring.tx.propagation.UserB;
import com.explore.sourceCodeTest.spring.tx.propagation.service.AUserService;
import com.explore.sourceCodeTest.spring.tx.propagation.service.BUserService;
import com.explore.sourceCodeTest.spring.tx.propagation.service.TXService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TXServiceImpl implements TXService {
	private static final Logger LOGGER=LoggerFactory.getLogger(TXServiceImpl.class);

	@Autowired
	private AUserService aUserService;
	@Autowired
	private BUserService bUserService;

	@Autowired
	private AMapper aDao;
	@Autowired
	private BMapper bDao;

	@Override
	public void notransaction_exception_required_required() {
		LOGGER.info("====================notransaction_exception_required_required==================================");
		UserA aUser = new UserA();
		aUser.setName("NERR-required-A");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("NERR-required-B");
		bUserService.addRequired(bUser);

		throw new RuntimeException("=======================外围方法抛出异常=============================");
	}

	@Override
	public void notransaction_required_required_exception() {
		LOGGER.info("====================notransaction_required_required_exception==================================");
		UserA aUser = new UserA();
		aUser.setName("NRRE-required-A");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("NRRE-required-E-B");
		bUserService.addRequiredException(bUser);
	}

	@Override
	public void transaction_exception_required_required() {
		LOGGER.info("====================transaction_exception_required_required==================================");
		UserA aUser = new UserA();
		aUser.setName("TERR-required-A");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("TERR-required-B");
		bUserService.addRequired(bUser);

		throw new RuntimeException("=======================外围方法抛出异常=============================");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception() {
		LOGGER.info("====================transaction_required_required_exception==================================");
		UserA aUser = new UserA();
		aUser.setName("TRRE-required-A");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("TRRE-required-E-B");
		bUserService.addRequiredException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception_try() {
		LOGGER.info("====================transaction_required_required_exception_try==================================");
		UserA aUser = new UserA();
		aUser.setName("TRRET-required-A");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("TRRET-required-E-T-B");
		try {
			bUserService.addRequiredException(bUser);
		} catch (Exception e) {
			LOGGER.info("=====================被调用的方法抛出的异常 被try-catch了===============================");
		}
	}

	@Override
	public void notransaction_exception_requiresNew_requiresNew() {
		LOGGER.info("====================notransaction_exception_requiresNew_requiresNew==================================");
		UserA aUser = new UserA();
		aUser.setName("NERnRn-requiresNew-A");
		aUserService.addRequiresNew(aUser);

		UserB bUser = new UserB();
		bUser.setName("NERnRn-requiresNew-B");
		bUserService.addRequiresNew(bUser);
		throw new RuntimeException("=======================外围方法抛出异常=============================");
	}

	@Override
	public void notransaction_requiresNew_requiresNew_exception() {
		LOGGER.info("====================notransaction_requiresNew_requiresNew_exception==================================");
		UserA aUser = new UserA();
		aUser.setName("NRnRnE-requiresNew-A");
		aUserService.addRequiresNew(aUser);

		UserB bUser = new UserB();
		bUser.setName("NRnRnE-requiresNew-E-B");
		bUserService.addRequiresNewException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_requiresNew_requiresNew() {
		LOGGER.info("====================transaction_exception_required_requiresNew_requiresNew==================================");
		UserA aUser = new UserA();
		aUser.setName("TERRnRn-required-A");
		aUserService.addRequired(aUser);

		UserA aUser2 = new UserA();
		aUser2.setName("TERRnRn-requiresNew-A");
		aUserService.addRequiresNew(aUser2);

		UserB bUser = new UserB();
		bUser.setName("TERRnRn-requiresNew-B");
		bUserService.addRequiresNew(bUser);
		throw new RuntimeException("=======================外围方法抛出异常=============================");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception() {
		LOGGER.info("====================transaction_required_requiresNew_requiresNew_exception==================================");
		UserA aUser = new UserA();
		aUser.setName("TRRnRnE-required-A");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("TRRnRnE-requiresNew-B");
		bUserService.addRequiresNew(bUser);

		UserB user3 = new UserB();
		user3.setName("TRRnRnE-requiresNew-E-B");
		bUserService.addRequiresNewException(user3);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception_try() {
		LOGGER.info("====================transaction_required_requiresNew_requiresNew_exception_try==================================");
		UserA aUser = new UserA();
		aUser.setName("TRRnRnET-required-A");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("TRRnRnET-requiresNew-B");
		bUserService.addRequiresNew(bUser);
		UserB user3 = new UserB();
		user3.setName("TRRnRnET-requiresNew-E-T-B");
		try {
			bUserService.addRequiresNewException(user3);
		} catch (Exception e) {
			LOGGER.info("=====================被调用的方法抛出的异常 被try-catch了===============================");
		}
	}

	@Override
	public void notransaction_exception_nested_nested() {
		LOGGER.info("====================notransaction_exception_nested_nested==================================");
		UserA aUser = new UserA();
		aUser.setName("NENN-nested-A");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("NENN-nested-B");
		bUserService.addNested(bUser);
		throw new RuntimeException("=======================外围方法抛出异常=============================");
	}

	@Override
	public void notransaction_nested_nested_exception() {
		LOGGER.info("====================notransaction_nested_nested_exception==================================");
		UserA aUser = new UserA();
		aUser.setName("NNNE-nested-A");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("NNNE-nested-E-B");
		bUserService.addNestedException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_nested_nested() {
		LOGGER.info("====================transaction_exception_nested_nested==================================");
		UserA aUser = new UserA();
		aUser.setName("TENN-nested-A");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("TENN-nested-B");
		bUserService.addNested(bUser);
		throw new RuntimeException("=======================外围方法抛出异常=============================");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_nested_nested_exception() {
		LOGGER.info("====================transaction_nested_nested_exception==================================");
		UserA aUser = new UserA();
		aUser.setName("TNNE-nested-A");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("TNNE-nested-E-B");
		bUserService.addNestedException(bUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_nested_nested_exception_try() {
		LOGGER.info("====================transaction_nested_nested_exception_try==================================");
		UserA aUser = new UserA();
		aUser.setName("TNNET-nested-A");
		aUserService.addNested(aUser);

		UserB bUser = new UserB();
		bUser.setName("TNNET-nested-E-T-B");
		try {
			bUserService.addNestedException(bUser);
		} catch (Exception e) {
			LOGGER.info("=====================被调用的方法抛出的异常 被try-catch了===============================");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void test() {
		UserA userA=new UserA();
		UserB userB=new UserB();

//		for (int i = 0; i <1000 ; i++) {
//			userA.setName("HAHAH"+i);
//			aUserService.insert(userA);
//		}
		userA.setName("AAAAAA20190529");
		userB.setName("BBBBBB20190529");
//		aUserService.insert(userA);
		aDao.insert(userA);
		bDao.insert(userB);
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void test2() {
		LOGGER.info("====================transaction_required_required_exception==================================");
		UserA aUser = new UserA();
		aUser.setName("TRRE-AAAAAA20190529");
		aUserService.addRequired(aUser);

		UserB bUser = new UserB();
		bUser.setName("TRRE-BBBBBB20190529");
		bUserService.addRequired(bUser);
	}
}
