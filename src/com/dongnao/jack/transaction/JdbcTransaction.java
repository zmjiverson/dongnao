package com.dongnao.jack.transaction;

import java.sql.Connection;

import com.dongnao.jack.datasource.DataSource;

public class JdbcTransaction implements Transaction {

	private DataSource dataSource;
	
	public JdbcTransaction(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public Connection getConnection() {

		
		return dataSource.getConnection();
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
