package com.dongnao.jack.executor;

import java.sql.SQLException;
import java.util.List;

import com.dongnao.jack.configTemplate.MappedStatement;

public interface Executor {

	<T> List<T> queryList(MappedStatement ms,Object param) throws SQLException;

    int update(MappedStatement ms,Object param);
    
    void commit();
    
    void rollback();
}
