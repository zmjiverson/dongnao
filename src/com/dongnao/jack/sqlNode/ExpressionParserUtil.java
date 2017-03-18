package com.dongnao.jack.sqlNode;

import java.util.Map;

public class ExpressionParserUtil {

	 public static <K,V> boolean expressionParser(Object param,String test){
		 
		 if(param instanceof Map){
			Map<K,V> paramMap=(Map<K,V>)param;
		 
		    for(Map.Entry<K, V> entry:paramMap.entrySet()){
		    	
		    	if(test.indexOf(entry.getKey().toString())>-1){
		    		
		    		String subStr=test.substring(test.indexOf(entry.getKey().toString()));
		    		
		    		if(subStr.indexOf("!=")>-1
		    				&&subStr.indexOf("null")>-1){
		    			
		    			if(entry.getValue()!=null&&
		    					!"".equals(entry.getValue().toString())){
		    				
		    				return true;
		    			}
		    		}
		    		
		    	}
		    }
		 }
		 
		 return false;
	 }
	 
	 public static StringBuffer parse(StringBuffer context,Object param){
		 
		 String open="#{";
		 String close="}";
		 
		 String after =  context.toString();
		 
		 int start=after.indexOf(open);
		 
		 int end = after.indexOf(close);
		 
		 StringBuffer newSb=new StringBuffer();
		 
		 while(start>-1){
			 String before=after.substring(0, start);
		 
		     String replaceparam=after.substring(start+open.length(), end);
		    
		     after = after.substring(close.length()+end);
		     
		     String paramValue="";
		     
		     if(param instanceof Map){
		    	 
		    	 Map paramMap=(Map)param;
		    	 if(paramMap.containsKey(replaceparam.trim())){
		    		 
		    		 paramValue=paramMap.get(replaceparam.trim()).toString();
		    	 }
		     }
		     
		     newSb.append(before).append(open);
		     
		     start=after.indexOf(open);
		     end=after.indexOf(close);
		 }
		 
		 newSb.append(after);
		 return newSb;
	 }
}
