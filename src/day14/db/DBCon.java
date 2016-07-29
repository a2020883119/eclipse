package day14.db;

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
//			System.out.println("forName()\t\tok");
			String uri = "jdbc:oracle:thin:@localhost:1521:test";
			//jdbc:oracle:thin:@localhost:1521:test
			String user = "test";
			String pwd = "123456";
			conn = DriverManager.getConnection(uri, user, pwd);
//			System.out.println("getConnection()\t\tok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("forName()\t\t\tfail");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("getConnection()\t\tfail");
		};
		return conn;
	}
	
	public void safeClose(Connection conn){
		try {
			if(conn != null){
				conn.close();
//				System.out.println("conn.close()\t\tok");
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
//					System.out.println("rs.close()\t\tok");
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
//				System.out.println("st.close()\t\tok");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
