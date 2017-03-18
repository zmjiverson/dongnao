package com.dongnao.jack.session;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.datasource.DataSource;
import com.dongnao.jack.executor.Executor;
import com.dongnao.jack.executor.SimpleExecutor;
import com.dongnao.jack.transaction.Transaction;
import com.dongnao.jack.transaction.TransactionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory{

	private Configuration config;
	
	public DefaultSqlSessionFactory(Configuration config) {
		this.config = config;
	}

	@Override
	public SqlSession createSqlSession() {
		System.out.println(config.getEnvironment());

		TransactionFactory tf=config.getEnvironment().getTransactionFactory();
		
		DataSource source = config.getEnvironment().getDataSource();
		
		Transaction ts = tf.createTransaction(source);
		
        Executor simpleExecutor = new SimpleExecutor(config, ts);		 
		
		return new DefaultSqlSession(config, simpleExecutor);
	}

	
}
