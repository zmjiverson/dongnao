package com.dongnao.jack.resultSetHandler;

import java.sql.Statement;
import java.util.List;

public interface ResultSetHandler {

    <T>	List<T> resultSetHandle(Statement stmt);
}
