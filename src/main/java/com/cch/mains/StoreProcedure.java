package com.cch.mains;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StoreProcedure {

	public static void main(String[] args) throws SQLException {
		// 加载Oracle驱动
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// 获得Oracle数据库连接
		String url = "";
		String userName = "";
		String password = "";
		Connection conn = DriverManager.getConnection(url, userName, password);

		// 创建存储过程的对象
		CallableStatement c = conn.prepareCall(" {call pro1(?)} ");

		// 给Oracle存储过程的参数设置值 ，将第一个参数的值设置成188
		// c.setInt( 1 , 188 );

		// 执行Oracle存储过程
		c.execute();
		conn.close();
	}

}
