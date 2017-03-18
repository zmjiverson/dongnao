package com.dongnao.jack.statementHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface StatementHandler {

	<T> List<T> query(Statement stmt) throws SQLException;

    int update(Statement stmt) throws SQLException;
    
    Statement createStatement(Connection conn) throws SQLException;
}
