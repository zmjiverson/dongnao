package com.dongnao.jack.transaction;

import com.dongnao.jack.datasource.DataSource;

public interface TransactionFactory {

	Transaction createTransaction(DataSource dataSource);
}
