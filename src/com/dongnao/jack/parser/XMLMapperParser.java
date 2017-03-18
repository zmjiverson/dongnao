package com.dongnao.jack.parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.configTemplate.MappedStatement;
import com.dongnao.jack.configTemplate.ResultMap;
import com.dongnao.jack.configTemplate.ResultMapping;

public class XMLMapperParser {

	public void parse(Node node,Configuration cf) throws Exception{
		
		if(node==null){
			throw new RuntimeException("node�ڵ㲻��Ϊ��");
		}
		if(!node.hasChildNodes()){
			throw new RuntimeException("node�ڵ���û����Ҫ������mapper");
		}
		NodeList nl = node.getChildNodes();
		
		for(int i=0;i<nl.getLength();i++){
			Node item = nl.item(i);
			
			if(item.getNodeType()!=Node.ELEMENT_NODE){
				continue;
			}
			MappedStatement ms = parseMapper(item,cf);
		}
	}
	
	private MappedStatement parseMapper(Node node,Configuration conf) throws Exception{
		if(!node.hasAttributes()){
			return new MappedStatement();
		}
		
		String resource = XMLParserUtil.getAttrValueByName(node, "resource");
		parse(resource,conf);
		return null;
	}
	
	private void parse(String url,Configuration cf) throws Exception{
		
		if(url==null){
			throw new RuntimeException("mapper��û��resource����");
		}
		
		InputStream is = XMLMapperParser.class.getResourceAsStream(url);
	    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(is);
	 
		NodeList nl = doc.getChildNodes();
		
		XMLStatementParser statementParser = new XMLStatementParser();
		
		for(int i=0;i<nl.getLength();i++){
			Node n = nl.item(i);
			
			if(n.getNodeType()!=Node.ELEMENT_NODE){
				continue;
			}
			
			String ns=XMLParserUtil.getAttrValueByName(n, "namespace");
		
		    NodeList childNodes = n.getChildNodes();
		    
		    for(int j=0;j<childNodes.getLength();j++){
		    	
		    	Node childNode = childNodes.item(j);
		        
		    	if(childNode.getNodeType()!=Node.ELEMENT_NODE){
		    		continue;
		    	}
		    	
		    	if("select".equals(childNode.getNodeName().toLowerCase())
		    			
		    			||"insert".equals(childNode.getNodeName().toLowerCase())
		    					
		    			||"update".equals(childNode.getNodeName().toLowerCase())
		    			
		    			||"delete".equals(childNode.getNodeName().toLowerCase())
		    			){
		    		
		    		statementParser.parse(childNode, cf, ns);
		    		
		    	}else if("resultmap".equals(childNode.getNodeName().toLowerCase())){
		    		parseResultMap(childNode, cf,ns);
		    	}
		    }
		}
	}
	
     private void parseResultMap(Node node,Configuration cf,String namespace) throws Exception{
		
		ResultMap rm = new ResultMap();
		
		String id = XMLParserUtil.getAttrValueByName(node, "id");
	
	    rm.setId(id);
	    
	    String type=XMLParserUtil.getAttrValueByName(node, "type");
	
	    rm.setType(type);
	    
	    rm.setTypeClass(Class.forName(type));
	
        List<ResultMapping> idrmings=new ArrayList<ResultMapping>(); 
     
        List<ResultMapping> resultrmings=new ArrayList<ResultMapping>();
     
        parseIdmings(resultrmings, node);
        
        parseResultming(resultrmings, node);
        
        rm.setIdResultMappings(idrmings);
        rm.setResultMappings(resultrmings);
        
        cf.getResultMaps().put(namespace+"."+id, rm);
        
     }
     
     private void parseIdmings(List<ResultMapping> idrmings,Node node){
    	 
    	 NodeList nodes = node.getChildNodes();
    	 
    	 for(int i=0;i<nodes.getLength();i++){
    		 Node item = nodes.item(i);
    		 
    		 if(item.getNodeType()==Node.ELEMENT_NODE||
    				"id".equals(item.getNodeName().toLowerCase()) ){
    			 
    			 ResultMapping rming = new ResultMapping();
    		     
    			 rming.setColumn(XMLParserUtil.getAttrValueByName(item, "column"));
    			 rming.setProperty(XMLParserUtil.getAttrValueByName(item, "property"));
    			 rming.setJdbcType(XMLParserUtil.getAttrValueByName(item, "jdbcType"));
    			 rming.setJavaType(XMLParserUtil.getAttrValueByName(item, "javaType"));
    		 
    			 idrmings.add(rming);
    		 }
    	 }
     }
     
     private void parseResultming(List<ResultMapping> resultrmings,Node node){
          NodeList nodes = node.getChildNodes();
    	 
    	 for(int i=0;i<nodes.getLength();i++){
    		 Node item = nodes.item(i);
    		 
    		 if(item.getNodeType()==Node.ELEMENT_NODE||
    				"result".equals(item.getNodeName().toLowerCase()) ){
    			 
    			 ResultMapping resultming = new ResultMapping();
    		     
    			 resultming.setColumn(XMLParserUtil.getAttrValueByName(item, "column"));
    			 resultming.setProperty(XMLParserUtil.getAttrValueByName(item, "property"));
    			 resultming.setJdbcType(XMLParserUtil.getAttrValueByName(item, "jdbcType"));
    			 resultming.setJavaType(XMLParserUtil.getAttrValueByName(item, "javaType"));
    		 
    			 resultrmings.add(resultming);
    		 }
    	 }
     }
}
