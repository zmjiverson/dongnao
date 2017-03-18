package com.dongnao.jack.parser;


import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.dongnao.jack.datasource.UnPooledDataSourceFactory;
import com.dongnao.jack.transaction.jdbcTransactionFactory;

public class XMLParserUtil {

	public static Map<String,Class<?>> PARAM_TYPE=new HashMap<String,Class<?>>();
	
	public static Map<String,Class<?>> CLASS_TYPE=new HashMap<String,Class<?>>();
	
	static{
		PARAM_TYPE.put("int", Integer.class);
		PARAM_TYPE.put("integer", Integer.class);
		PARAM_TYPE.put("double", Double.class);
		PARAM_TYPE.put("float", Float.class);
		PARAM_TYPE.put("byte", Byte.class);
		PARAM_TYPE.put("long", Long.class);
		PARAM_TYPE.put("boolean", Boolean.class);
		
		CLASS_TYPE.put("JDBC", jdbcTransactionFactory.class);
		CLASS_TYPE.put("UNPOOLED",UnPooledDataSourceFactory.class );
	}
	
	public static String  getAttrValueByName(Node node,String name){
		NamedNodeMap attrs = node.getAttributes();
		for(int i=0;i<attrs.getLength();i++){
			Node attr = attrs.item(i);
			
			if(name.equals(attr.getNodeName())){
				return attr.getNodeValue();
			}
		}
		
		return null;
	}
}
