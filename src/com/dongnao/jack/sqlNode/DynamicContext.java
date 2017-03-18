package com.dongnao.jack.sqlNode;

public class DynamicContext {

	private StringBuffer sb;

	private Object param;
	
	public DynamicContext(StringBuffer sb, Object param) {
		this.sb = sb;
		this.param = param;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public StringBuffer getSb() {
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}
	
	
}
