package com.dongnao.jack.test;

import java.util.HashMap;
import java.util.Map;

import com.dongnao.jack.session.SqlSession;
import com.dongnao.jack.session.SqlSessionFactory;
import com.dongnao.jack.session.SqlSessionFactoryBuilder;

public class Test {

	public static void main(String[] args) throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		SqlSessionFactory sessionFactory = builder.build("/com/dongnao/jack/config/SqlMapConfig.xml");
	
		SqlSession session = sessionFactory.createSqlSession();
		
		Map<String,String> paramMap=new HashMap<String,String>();
		
		paramMap.put("type", "1");
		session.selectList("com.dongnao.jack.selectPerson", paramMap);
	}

	
}
