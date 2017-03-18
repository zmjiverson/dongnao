package com.dongnao.jack.datasource;

public class UnPooledDataSourceFactory implements DataSourceFactory{

    private String driver;
	
	private String url;
	
	private String userName;
	
	private String password;
	
	public UnPooledDataSourceFactory(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}



	@Override
	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		return new UnPooledDataSource(driver,url,userName,password);
	}



	public String getDriver() {
		return driver;
	}



	public void setDriver(String driver) {
		this.driver = driver;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	
}
