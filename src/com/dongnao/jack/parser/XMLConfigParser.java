package com.dongnao.jack.parser;

import java.io.InputStream;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.configTemplate.Environment;
import com.dongnao.jack.datasource.DataSource;
import com.dongnao.jack.datasource.DataSourceFactory;
import com.dongnao.jack.transaction.TransactionFactory;

public class XMLConfigParser {

	public Configuration parse(InputStream is) throws Exception{
		System.out.println(is);
		Configuration config = parseConfiguration(is);
		
		return config;
	}
	
	private Configuration parseConfiguration(InputStream is) throws Exception{
		
		Configuration config = new Configuration();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(is);
		
		NodeList nl = doc.getChildNodes();
		
		XMLMapperParser  mapperParser=new XMLMapperParser();
		
		for(int i=0;i<nl.getLength();i++){
			System.out.println(nl.getLength());
			Node node = nl.item(i);
			
			if(node.getNodeType()!=Node.ELEMENT_NODE){
				continue;
			}
			
			if("configuration".equals(node.getNodeName())){
				NodeList childNodes = node.getChildNodes();
                
				for(int j=0;j<childNodes.getLength();j++){
					Node child = childNodes.item(i);
					System.out.println(child.getNodeName());
					if(child.getNodeType()!=Node.ELEMENT_NODE){
						continue;
					}
					
					if("mappers".equals(child.getNodeName())){
						System.out.println("222");
						mapperParser.parse(child, config);
					}else if("environments".equals(child.getNodeName())){
						System.out.println("111");
						parseEnvironments(child,config);
					}
				}
			}
		}
		return config;
	}
	
	private void parseEnvironments(Node node,Configuration cf) throws Exception{
		
		Environment em = new Environment();
	    
		NodeList nl = node.getChildNodes();
		
		for(int j=0;j<nl.getLength();j++){
			Node child = nl.item(j);
			if(child.getNodeType()!=Node.ELEMENT_NODE){
				continue;
			}
			
			if("environment".equals(child.getNodeName().toLowerCase())){
				NodeList childitems = child.getChildNodes();
			
				for(int i=0;i<childitems.getLength();i++){
					Node item = childitems.item(i);
				
					if(item.getNodeType()!=Node.ELEMENT_NODE){
						continue;
					} 
					
					if("transactionmanager".equals(item.getNodeName().toLowerCase())){
						String type=XMLParserUtil.getAttrValueByName(item, "type");
					    
						 TransactionFactory factory = (TransactionFactory)XMLParserUtil.CLASS_TYPE.get(type).newInstance();
					     
						 em.setTransactionFactory(factory);
					}
					
					if("datasource".equals(item.getNodeName().toLowerCase())){
						
						String type = XMLParserUtil.getAttrValueByName(item, "type");
					
						DataSourceFactory factory = (DataSourceFactory)XMLParserUtil.CLASS_TYPE.get(type).newInstance();
						
						NodeList propsNode = item.getChildNodes();
						
						for(int x=0;x<propsNode.getLength();x++){
							
							Node prop = propsNode.item(x);
						
						    if(prop.getNodeType()!=Node.ELEMENT_NODE){
						    	continue;
						    }
						    
						    String name = XMLParserUtil.getAttrValueByName(prop, "name");
						
						    String value=XMLParserUtil.getAttrValueByName(prop, "value");
						    
						    Method setMethod = factory.getClass().getMethod("set"+name.substring(0, 1).toUpperCase()+name.substring(1), String.class);
						    
						    setMethod.invoke(factory, value);
						}
						
						
						DataSource dataSource = factory.getDataSource();
					
					    em.setDataSource(dataSource);
					}
				}
			}
		}
		cf.setEnvironment(em);
	}
}
