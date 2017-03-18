package com.dongnao.jack.configTemplate;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

	Map<String,MappedStatement>  MappedStatement=new HashMap<String,MappedStatement>();
	
	Map<String,ResultMap> resultMaps=new HashMap<String,ResultMap>();
	
	Environment environment;

	public Map<String, MappedStatement> getMappedStatement() {
		return MappedStatement;
	}

	public void setMappedStatement(Map<String, MappedStatement> mappedStatement) {
		MappedStatement = mappedStatement;
	}

	public Map<String, ResultMap> getResultMaps() {
		return resultMaps;
	}

	public void setResultMaps(Map<String, ResultMap> resultMaps) {
		this.resultMaps = resultMaps;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	
}
