package com.dongnao.jack.typeHandler;

import java.util.HashMap;
import java.util.Map;

public class TypeHandlerConfig {

	public static Map<String,TypeHandler> JDBC_TYPE_HANDLER=new HashMap<String,TypeHandler>();

    static{
    	JDBC_TYPE_HANDLER.put("VARCHAR", new StringTypeHandler());
    }
    
    
}
