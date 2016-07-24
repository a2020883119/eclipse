package day11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestJDBC {
	static String uri = "jdbc:oracle:thin:@localhost:1521:ORCL";
	static String user = "WSZZ";
	static String pwd = "123456";
	static Connection conn;
	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(uri, user, pwd);
		if(conn == null){
			System.out.println("error");
		}
//		delete();
//		updata();
//		insert();
//		select();
//		delete();
//		updata();
	}
	static void insert() throws SQLException{
		select();
		String sql = "INSERT INTO EMP VALUES(122, '12222222', '', '', '', '', '', '')";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		select();
	}
	static void delete() throws SQLException{	
			select();
			String sql = "delete from EMP where id = 100";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println(" delete is ok");
			select();
	}
	static void updata() throws SQLException{
		select();
		String sql = "UPDATE EMP SET AGE = 3 WHERE ID = 100";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		select();
	}
	static void select() throws SQLException{
		String sql = "select * from EMP";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("Id\tName\tAge\tGender\t\tAddr\tPhone\t\tSalary");
		System.out.println("---------------------------------------------------------------------");
		while(rs.next()){
			System.out.println(rs.getInt("ID") +"\t"+ rs.getString("NAME") +"\t"+ rs.getInt("AGE") +"\t"+ rs.getString("GENDER") +"\t"+ rs.getString("ADDR") +"\t"+ rs.getString("PHONE")+"\t" + rs.getInt("SALARY"));
		}
	}
}
