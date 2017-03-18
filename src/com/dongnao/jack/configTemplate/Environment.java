package com.dongnao.jack.configTemplate;

import com.dongnao.jack.datasource.DataSource;
import com.dongnao.jack.transaction.TransactionFactory;

public class Environment {

	private DataSource dataSource;
	
	private TransactionFactory  transactionFactory;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public TransactionFactory getTransactionFactory() {
		return transactionFactory;
	}

	public void setTransactionFactory(TransactionFactory transactionFactory) {
		this.transactionFactory = transactionFactory;
	}
	
	
}
