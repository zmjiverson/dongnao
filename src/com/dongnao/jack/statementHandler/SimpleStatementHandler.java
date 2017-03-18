package com.dongnao.jack.statementHandler;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.configTemplate.MappedStatement;
import com.dongnao.jack.connectionHandler.ConnectionHandler;
import com.dongnao.jack.resultSetHandler.FastResultSetHandler;
import com.dongnao.jack.sqlNode.BoundSql;

public class SimpleStatementHandler implements StatementHandler {

	private BoundSql boundSql;
	
	private Configuration config;
	
	private MappedStatement ms;
	
	private Connection connection;
	
	public SimpleStatementHandler(BoundSql boundSql, Configuration config, MappedStatement ms, Connection connection) {
		this.boundSql = boundSql;
		this.config = config;
		this.ms = ms;
		this.connection = connection;
	}

	@Override
	public <T> List<T> query(Statement stmt) throws SQLException {

		stmt.execute(boundSql.getSql());
		
		FastResultSetHandler resultSetHandler = new FastResultSetHandler(stmt,config,ms);
		
		List<T> result = resultSetHandler.resultSetHandle(stmt);
		
		return result;
	}

	@Override
	public int update(Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Statement createStatement(Connection conn) throws SQLException {
		
		conn=(Connection)Proxy.newProxyInstance(Connection.class.getClassLoader(), 
				new Class<?>[] {Connection.class} , 
				new ConnectionHandler(conn,boundSql));
		
		return conn.createStatement();
	}

}
