package com.tang.dbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


/**
 * 数据库连接
 * @author Administrator
 *
 */
public class DBManager {
	
	/**
	 * init parameter
	 */
	static String driver;
	static String url;
	static String username;
	static String password;
	
	static{
		InputStream in = DBManager.class.getClassLoader().getResourceAsStream("db.properties");
		Properties ps = new Properties();
		try {
			ps.load(in);
			driver = ps.getProperty("driver");
			url = ps.getProperty("url");
			username = ps.getProperty("username");
			password = ps.getProperty("password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 取得数据库的连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	// 关闭数据库
	public static void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn){
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(pstmt != null){
			try{
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		DBManager.getConnection();
	}
}
