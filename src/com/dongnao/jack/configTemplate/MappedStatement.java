package com.dongnao.jack.configTemplate;

import com.dongnao.jack.sqlNode.BoundSql;
import com.dongnao.jack.sqlNode.SqlSource;

public class MappedStatement {

	private String id;
	
	private String parameterType;
	
	private Class<?> parameterTypeClass;
	
	private String resultType;
	
	private String resultMapRef;

	private SqlSource sqlSource;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public Class<?> getParameterTypeClass() {
		return parameterTypeClass;
	}

	public void setParameterTypeClass(Class<?> parameterTypeClass) {
		this.parameterTypeClass = parameterTypeClass;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultMapRef() {
		return resultMapRef;
	}

	public void setResultMapRef(String resultMapRef) {
		this.resultMapRef = resultMapRef;
	}

	public SqlSource getSqlSource() {
		return sqlSource;
	}

	public void setSqlSource(SqlSource sqlSource) {
		this.sqlSource = sqlSource;
	}
	
	
	public BoundSql getBoundSql(Object param){
		
		BoundSql boundSql = sqlSource.getBoundSql(param);
		
		return boundSql;
	}
}
