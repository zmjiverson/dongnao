package com.dongnao.jack.datasource;

import java.sql.Connection;

public interface DataSource {

	public Connection getConnection();
}
