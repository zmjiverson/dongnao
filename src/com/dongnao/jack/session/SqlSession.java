package com.dongnao.jack.session;

import java.sql.Connection;
import java.util.List;

public interface SqlSession {
	
  <T> List<T> selectList(String sql,Object param);

  <T> T	selectOne(String sql);
  
  <T> T selectOne(String sql,Object param);

  int insert(String sql);
  
  int insert(String sql,Object param);
  
  int update(String sql);
  
  int update(String sql,Object param);
  
  int delete(String sql);
  
  int delete(String sql,Object param);
  
  void commit();
  
  void rollback();
  
  Connection getConnection();
}
