package day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcConnPrac {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
//		getConn();
//		queryData();
//		insertData();
//		deleteData();
//		updateData();
	}
	
	public static void menu(){
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;
		while(exit){
			System.out.println("[0] exit\n[1] query\n[2] insert\n[3] delete\n[4] update\nplease in put number 0-4");
			switch (scanner.nextInt()) {
			case 0:
				exit = false;
				break;
			case 1:
				queryData();
				break;
			case 2:
				insertData();
				break;
			case 3:
				deleteData();
				break;
			case 4:
				updateData();
				break;
			default:
				break;
			}
		}
	}
	
	public static Connection getConn(){
		Connection conn = null;
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
	
	public static void safeClose(Connection conn){
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
	
	public static void safeClose(ResultSet rs){
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
	
	public static void safeClose(Statement st){
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
	
	public static void queryData(){
		Connection conn = getConn();
		String sql = "select * from users order by id";
		int id = -1;
		String account, password;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println("----------------------------------------------------------");
			System.out.println("\tID\t\tACCOUNT\t\tPASSWORD\n");
			while(rs.next()){
				id = rs.getInt("id");
				account = rs.getString("account");
				password = rs.getString("password");
				System.out.println("\t" + id + "\t\t" + account + "\t\t" + password);
			}
			System.out.println("----------------------------------------------------------");
			safeClose(rs);
			safeClose(st);
			safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void insertData(){
		Scanner scanner = new Scanner(System.in);
		Connection conn = getConn();
		queryData();
		System.out.println("for  example:101 account password");
		System.out.print("please input:");
		int id = scanner.nextInt();
		String account = scanner.next();
		String password = scanner.next();
		String sql = "select * from users where id = " + id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(!rs.next()){
				sql = "insert into users values(" + id + ", '" + account + "', '" + password + "')";
				if(st.executeUpdate(sql) != 0){
					queryData();
				}
			}else{
				System.out.println("id = " + id + " exists");
				queryData();
			}
			safeClose(rs);
			safeClose(st);
			safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteData(){
		Scanner scanner = new Scanner(System.in);
		Connection conn = getConn();
		queryData();
		System.out.println("for  example:101");
		System.out.print("please input:");
		int id = scanner.nextInt();
		String sql = "select * from users where id = " + id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				sql = "delete users where id = " + id;
				if(st.executeUpdate(sql) != 0){
					queryData();
				}
			}else{
				System.out.println("id = " + id + " not exists");
				queryData();
			}
			safeClose(rs);
			safeClose(st);
			safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateData(){
		Scanner scanner = new Scanner(System.in);
		Connection conn = getConn();
		queryData();
		System.out.println("for  example:101");
		System.out.print("please input:");
		int id = scanner.nextInt();
		int iddd = id;
		String sql = "select * from users where id = " + id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				System.out.print("input '0' to skip\n");
				System.out.print("please input id:");
				int idd = scanner.nextInt();
				if(!"0".equals(String.valueOf(idd)))
				{
					sql = "select * from users where id = " + idd;
					rs = st.executeQuery(sql);
					if(!rs.next()){
						safeClose(rs);
						sql = "update users set id = " + idd + " where id = " + id;
						st.executeUpdate(sql);
						iddd = idd;
					}else{
						safeClose(rs);
						System.out.println("id = " + id + " exists");
						return;
					}
				}
				System.out.print("please input account:");
				String account = scanner.next();
				if(!"0".equals(account))
				{
					sql = "update users set account = '" + account + "' where id = " + iddd;
					st.executeUpdate(sql);
				}
				System.out.print("please input password:");
				String password = scanner.next();
				if(!"0".equals(password))
				{
					sql = "update users set password = '" + password + "' where id = " + iddd;
					st.executeUpdate(sql);
				}
				queryData();
			}else{
				System.out.println("id = " + id + " not exists");
				queryData();
			}
			safeClose(st);
			safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

	