package com.explore.sourceCodeTest.spring.tx.propagation.service;

public interface TXService {
	/**
	 * PROPAGATION_REQUIRED
	 * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	 */
	//====================================外围方法无事务=======================================
	//外围方法没有开启事务 并且外围方法发生异常
	void notransaction_exception_required_required();

	//外围方法没有开启事务 被调用的方法发生异常
	void notransaction_required_required_exception();

	//====================================外围方法有事务=======================================
	//外围方法开启事务 并且外围方法发生异常
	void transaction_exception_required_required();

	//外围方法开启事务 被调用的方法发生异常
	void transaction_required_required_exception();

	//外围方法开启事务 被调用的方法发生异常 不过异常被外围方法catch了
	void transaction_required_required_exception_try();

	/**
	 * PROPAGATION_REQUIRES_NEW
	 * 新建事务，如果当前存在事务，把当前事务挂起。
	 */
	//====================================外围方法无事务=======================================
	//外围方法没有开启事务 并且外围方法发生异常
	void notransaction_exception_requiresNew_requiresNew();

	//外围方法没有开启事务 被调用的方法发生异常
	void notransaction_requiresNew_requiresNew_exception();

	//====================================外围方法有事务=======================================
	//外围方法开启事务 并且外围方法发生异常
	void transaction_exception_required_requiresNew_requiresNew();

	//外围方法开启事务 被调用的方法发生异常
	void transaction_required_requiresNew_requiresNew_exception();

	//外围方法开启事务 被调用的方法发生异常 不过异常被外围方法catch了
	void transaction_required_requiresNew_requiresNew_exception_try();

	/**
	 * PROPAGATION_NESTED
	 * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
	 */
	//====================================外围方法无事务=======================================
	//外围方法没有开启事务 并且外围方法发生异常
	void notransaction_exception_nested_nested();

	//外围方法没有开启事务 被调用的方法发生异常
	void notransaction_nested_nested_exception();

	//====================================外围方法有事务=======================================
	//外围方法开启事务 并且外围方法发生异常
	void transaction_exception_nested_nested();

	//外围方法开启事务 被调用的方法发生异常
	void transaction_nested_nested_exception();

	//外围方法开启事务 被调用的方法发生异常 不过异常被外围方法catch了
	void transaction_nested_nested_exception_try();

	void test();

	void test2();
}
















