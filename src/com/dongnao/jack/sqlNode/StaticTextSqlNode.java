package com.dongnao.jack.sqlNode;

public class StaticTextSqlNode implements SqlNode{

	private String text;
	
	
	
	public StaticTextSqlNode(String text) {
		this.text = text;
	}

	@Override
	public boolean appendTo(DynamicContext context) {

		context.getSb().append(text);
		
		return false;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
}
