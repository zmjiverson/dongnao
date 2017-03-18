package com.dongnao.jack.typeHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StringTypeHandler implements TypeHandler {

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {

		return rs.getString(columnName);
	}

}
