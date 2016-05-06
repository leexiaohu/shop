package com.shop.PUB;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 说明：获取数据库连接
 * @author hzy
 *
 */
public class GetConnection {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USERNAME = "dsy";
	private static final String PASSWORD = "123";
	public static Connection getConnection() throws Exception{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
		return conn;
		
	}
}
