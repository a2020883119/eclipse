package day16.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	public static Connection conn = null;
	
	public DBCon(){
	}
	
	public Connection getConn() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uri = "jdbc:oracle:thin:@localhost:1521:test";
			String user = "test";
			String pwd = "123456";
			conn = DriverManager.getConnection(uri, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		};
		return conn;
	}
	
	public void safeClose(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void safeClose(ResultSet rs){
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void safeClose(Statement st){
		try {
			if(st != null)
			{
				st.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
