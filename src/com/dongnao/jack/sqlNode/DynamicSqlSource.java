package com.dongnao.jack.sqlNode;

import java.util.List;

public class DynamicSqlSource implements SqlSource {

	List<SqlNode> sqlNode;
	
	@Override
	public BoundSql getBoundSql(Object param) {

		DynamicContext context = new DynamicContext(new StringBuffer(),param);
		
		for(SqlNode sqlNode:sqlNode){
			sqlNode.appendTo(context);
		}
		
		String paramSql = context.getSb().toString();
		
		StringBuffer sql=ExpressionParserUtil.parse(context.getSb(), param);
		
		return new BoundSql(sql.toString());
	}

	public List<SqlNode> getSqlNode() {
		return sqlNode;
	}

	public void setSqlNode(List<SqlNode> sqlNode) {
		this.sqlNode = sqlNode;
	}

	public DynamicSqlSource(List<SqlNode> sqlNode) {
		this.sqlNode = sqlNode;
	}

}
