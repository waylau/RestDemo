package com.waylau.util;


import com.waylau.util.PropertiesUtils;

public class Constants {


	/***************** system *****************/
	public static final String CLASSPATH = Constants.class.getResource("//").getFile();
	public static String DB_NAME = "";

	/***************** default password (123456) *****************/
	public static final String DEFAULT_PASSWORD = "14e1b600b1fd579f47433b88e8d85291";

	/***************** session key *****************/
	public static final String CURRENT_USER = "CURRENT_USER";
	public static final String ENTER_COUNT = "ENTER_COUNT";
	public static final String NEED_CAPTCHA = "NEED_CAPTCHA";

	/***************** page *****************/
	public static final String LOGIN_PAGE = "jsp/login.jsp";
	public static final String INDEX_PAGE = "jsp/frame/index.jsp";
	public static final String EXCEPTION_PAGE = "jsp/error/exception.jsp";

	/***************** redis key *****************/
	public static final String MENU = "menu";
	public static final String MENU_TOP = "menuTop";
	public static final String MENU_MAIN = "menuMain";

	static {
		String driverClassName = PropertiesUtils.getProperty("/jdbc.properties", "database.driverClassName");
		if ("com.microsoft.sqlserver.jdbc.SQLServerDriver".equals(driverClassName)) {
			Constants.DB_NAME = "sqlserver";
		} else if ("oracle.jdbc.driver.OracleDriver".equals(driverClassName)) {
			Constants.DB_NAME = "oracle";
		} else if ("com.mysql.jdbc.Driver".equals(driverClassName)) {
			Constants.DB_NAME = "mysql";
		}
 
	}

}
