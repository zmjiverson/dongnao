package com.dongnao.jack.typeHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface TypeHandler {

	
  Object getResult(ResultSet rs,String columnName) throws SQLException;
}
