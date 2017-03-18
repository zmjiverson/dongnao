package com.dongnao.jack.sqlNode;

import java.util.List;

public class IfSqlNode implements SqlNode{

	private String test;
	
	private List<SqlNode> sqlNode;
	@Override
	public boolean appendTo(DynamicContext context) {

		Object param = context.getParam();
		
		if(ExpressionParserUtil.expressionParser(param, test)){
			for(SqlNode sqlnode:sqlNode){
				sqlnode.appendTo(context);
			}
		}
		
		return false;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public List<SqlNode> getSqlNode() {
		return sqlNode;
	}
	public void setSqlNode(List<SqlNode> sqlNode) {
		this.sqlNode = sqlNode;
	}
	public IfSqlNode(String test, List<SqlNode> sqlNode) {
		this.test = test;
		this.sqlNode = sqlNode;
	}

	
}
