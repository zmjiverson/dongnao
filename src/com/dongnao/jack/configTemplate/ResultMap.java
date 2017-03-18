package com.dongnao.jack.configTemplate;

import java.util.List;

public class ResultMap {

	private String id;
	
	private String type;
	
	private Class<?> typeClass;
	
	 List<ResultMapping> idResultMappings;
	
	 public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Class<?> getTypeClass() {
		return typeClass;
	}

	public void setTypeClass(Class<?> typeClass) {
		this.typeClass = typeClass;
	}

	public List<ResultMapping> getIdResultMappings() {
		return idResultMappings;
	}

	public void setIdResultMappings(List<ResultMapping> idResultMappings) {
		this.idResultMappings = idResultMappings;
	}

	public List<ResultMapping> getResultMappings() {
		return resultMappings;
	}

	public void setResultMappings(List<ResultMapping> resultMappings) {
		this.resultMappings = resultMappings;
	}

	List<ResultMapping> resultMappings;
}
