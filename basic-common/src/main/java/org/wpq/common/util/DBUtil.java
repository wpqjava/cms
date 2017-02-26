package org.wpq.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;
	
	public static Connection getCon(){
		if(con==null){
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms_test?sessionVariables=foreign_key_checks=0&useSSL=false", "root", "123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void close(Connection con){
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
