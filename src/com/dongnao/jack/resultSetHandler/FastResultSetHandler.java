package com.dongnao.jack.resultSetHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dongnao.jack.configTemplate.Configuration;
import com.dongnao.jack.configTemplate.MappedStatement;
import com.dongnao.jack.configTemplate.ResultMap;
import com.dongnao.jack.configTemplate.ResultMapping;
import com.dongnao.jack.typeHandler.TypeHandler;
import com.dongnao.jack.typeHandler.TypeHandlerConfig;

public class FastResultSetHandler implements ResultSetHandler {

	private Statement stmt;
	
	private Configuration config;
	
	private MappedStatement ms;
	
	
	public Statement getStmt() {
		return stmt;
	}



	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}



	public Configuration getConfig() {
		return config;
	}



	public void setConfig(Configuration config) {
		this.config = config;
	}



	public MappedStatement getMs() {
		return ms;
	}



	public void setMs(MappedStatement ms) {
		this.ms = ms;
	}



	public FastResultSetHandler(Statement stmt, Configuration config, MappedStatement ms) {
		super();
		this.stmt = stmt;
		this.config = config;
		this.ms = ms;
	}



	@Override
	public <T> List<T> resultSetHandle(Statement stmt) {

		ResultMap resultMap = config.getResultMaps().get(ms.getResultMapRef());
		
		List<ResultMapping> idrmings=resultMap.getIdResultMappings();
		
		List<ResultMapping> resultMappings = resultMap.getResultMappings();
		
		Class<?> type = resultMap.getTypeClass();
		
		List<T> result = new ArrayList<T>();
		
		try {
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()){
				T instance = (T)type.newInstance();
			
				idresultMappings(result,instance,rs,idrmings);
			
				resultMappings(result,instance,rs,resultMappings);
				
				result.add(instance);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	private <T> void idresultMappings(List<T> result, Object instances,ResultSet rs,List<ResultMapping> idrmpings){
		
		if(idrmpings==null||idrmpings.size()==0){
			return;
		}
		
		for(ResultMapping rm:idrmpings){
			String column = rm.getColumn();
		
		    String jdbcType = rm.getJdbcType();
		
		    String javaType = rm.getJavaType();
		
		    String property = rm.getProperty();
		    
		    TypeHandler typeHandler = TypeHandlerConfig.JDBC_TYPE_HANDLER.get(jdbcType);
		
		    try {
				Object value = typeHandler.getResult(rs, column);
			
				Field field = instances.getClass().getField(property);
		    
				field.setAccessible(true);
				
				field.set(instances, value);
		    } catch (SQLException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
private <T> void resultMappings(List<T> result, Object instances,ResultSet rs,List<ResultMapping> idrmpings){
		
		if(idrmpings==null||idrmpings.size()==0){
			return;
		}
		
		for(ResultMapping rm:idrmpings){
			String column = rm.getColumn();
		
		    String jdbcType = rm.getJdbcType();
		
		    String javaType = rm.getJavaType();
		
		    String property = rm.getProperty();
		    
		    TypeHandler typeHandler = TypeHandlerConfig.JDBC_TYPE_HANDLER.get(jdbcType);
		
		    try {
				Object value = typeHandler.getResult(rs, column);
			
				Field field = instances.getClass().getField(property);
		    
				field.setAccessible(true);
				
				field.set(instances, value);
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
