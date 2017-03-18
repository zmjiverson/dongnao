package com.dongnao.jack.session;

import java.io.InputStream;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.parser.XMLConfigParser;

public class SqlSessionFactoryBuilder {

	public SqlSessionFactory build(String path) throws Exception{
		
		InputStream is = SqlSessionFactoryBuilder.class.getResourceAsStream(path);
		
		XMLConfigParser parse = new XMLConfigParser();
		
		Configuration config=null;
		try {
		
			config = parse.parse(is);
			System.out.println(config.getEnvironment());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new DefaultSqlSessionFactory(config);
	}
}
