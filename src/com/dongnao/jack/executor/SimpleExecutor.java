package com.dongnao.jack.executor;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.configTemplate.MappedStatement;
import com.dongnao.jack.sqlNode.BoundSql;
import com.dongnao.jack.statementHandler.SimpleStatementHandler;
import com.dongnao.jack.transaction.Transaction;

public class SimpleExecutor implements Executor {

	private Configuration config;
	
	private Transaction transaction;
	
	public SimpleExecutor(Configuration config, Transaction transaction) {
		this.config = config;
		this.transaction = transaction;
	}

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public <T> List<T> queryList(MappedStatement ms, Object param) throws SQLException {

		BoundSql boundSql = ms.getBoundSql(param);
		
		SimpleStatementHandler handler = new SimpleStatementHandler(boundSql,config,ms,transaction.getConnection());
		
		Statement stmt = handler.createStatement(transaction.getConnection());
		
		List<T> result = handler.query(stmt);	
		return null;
	}

	@Override
	public int update(MappedStatement ms, Object param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

}
