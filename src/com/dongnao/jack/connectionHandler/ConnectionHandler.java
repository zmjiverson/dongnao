package com.dongnao.jack.connectionHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

import com.dongnao.jack.sqlNode.BoundSql;

public class ConnectionHandler implements InvocationHandler {

	private Connection conn;
	
	private BoundSql boundSql;
	

	public BoundSql getBoundSql() {
		return boundSql;
	}



	public void setBoundSql(BoundSql boundSql) {
		this.boundSql = boundSql;
	}



	public ConnectionHandler(Connection conn, BoundSql boundSql) {
		super();
		this.conn = conn;
		this.boundSql = boundSql;
	}



	public Connection getConn() {
		return conn;
	}



	public void setConn(Connection conn) {
		this.conn = conn;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("execute by:"+method.getName());
		
		System.out.println("SQL is : ["+boundSql.getSql()+"]");
		
		return method.invoke(conn, args);
	}

}
