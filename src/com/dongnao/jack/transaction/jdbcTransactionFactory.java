package com.dongnao.jack.transaction;

import com.dongnao.jack.datasource.DataSource;

public class jdbcTransactionFactory implements TransactionFactory{

	private DataSource dataSource;
	
	
	public jdbcTransactionFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Transaction createTransaction(DataSource dataSource) {
		
		
		return new JdbcTransaction(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
}
