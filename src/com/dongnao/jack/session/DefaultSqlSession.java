package com.dongnao.jack.session;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.configTemplate.MappedStatement;
import com.dongnao.jack.executor.Executor;

public class DefaultSqlSession implements SqlSession{

	private Configuration config;
	
	private Executor executor;
	
	public DefaultSqlSession(Configuration config, Executor executor) {
		this.config = config;
		this.executor = executor;
	}

	@Override
	public <T> T selectOne(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T selectOne(String sql, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(String sql, Object param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sql, Object param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String sql, Object param) {
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

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> selectList(String sql, Object param) {
		
		MappedStatement ms = config.getMappedStatement().get(sql);
		
		if(ms==null){
			throw new RuntimeException();
		}
		
		try {
			List<T> result = executor.queryList(ms, param);
		
		    return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	
}
