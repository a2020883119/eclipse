package day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		getCon();
		login();
//		menu();
//		query();
//		add();
//		change();
//		delete();
	}
	
	//close the conn
	public static void connClose(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Close is fialed");
			e.printStackTrace();
		}
//		System.out.println("close is success");
	}
	
	//get conn
	
	public static Connection getCon(){
		String uri = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String username = "WSZZ";
		String password = "123456";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection(uri, username, password);
			if(conn == null){
				System.out.println("connection is failed.");
				return null;
			}else{
//				System.out.println("connection is successed.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;	
	}
	
	//get conn by dbName
	
	public static Connection getCon(String dbName){
		String uri = "jdbc:oracle:thin:@localhost:1521:" + dbName;
		String username = "WSZZ";
		String password = "123456";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection(uri, username, password);
			if(conn == null){
				System.out.println("connection is failed.");
				return null;
			}else{
				System.out.println("connection is successed.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;	
	}
	
	//login
	public static void login() throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.print("【LOGIN】Username: ");
		String username = scanner.next();
		System.out.print("【LOGIN】Password: ");
		String password = scanner.next();
		Connection conn = getCon();
		Statement stm = conn.createStatement();
//		String sql = "select * from emp where id=?";// 预编译语句，“？”代表参数
//		PreparedStatement pre = conn.prepareStatement(sql);// 实例化预编译语句
//        pre.setString(1, "123456");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
//        ResultSet result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
//        System.out.println("姓名:"+ result.getString("PWD"));
//        while (result.next()){
//            System.out.println("姓名:"+ result.getString("pwd"));
//        }
		String sql = "SELECT * FROM USERS WHERE ID = '" + username + "'";
		String sql2 = "SELECT * FROM USERS WHERE ID = '" + username + "' AND PWD = '" + password + "'";
		ResultSet rs = stm.executeQuery(sql);
		if(rs.next()){
				if(password.equals(rs.getString("PWD"))){
					System.out.println("【LOGIN】[LOGIN SUCCESS]");
					connClose(conn);
					menu();
					System.out.println("【LOGIN】[login out]");
				}else{
					System.out.println("【LOGIN】[WRONG PASSWORD]");
				}
		}else{			
			System.out.println("【LOGIN】[USERNAME IS NOT EXISTS]");
		}
	}
	
	//function menu
	public static void menu() throws Exception{
		int num;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----MENU----\n【MENU】[0]exist\n【MENU】[1]add\n【MENU】[2]delete\n【MENU】[3]query\n【MENU】[4]change");
		while((num = scanner.nextInt()) > 0){
			switch(num){
			case 1 :
				add();
				break;
			case 2 :
				delete();
				break;
			case 3 :
				query();
				break;
			case 4 :
				change();
				break;
			default :
				System.out.println("【MENU】Illegal Number!");
				break;	
			}
			System.out.println("----MENU----\n[0]exist\n[1]add\n[2]delete\n[3]query\n[4]change\n");
		}
		System.out.println("【MENU】exit");
	}
	
	// add func
	public static void add() throws Exception{
		Connection conn;
		String pwd, sql, name, gender, classs, date, remarks;
		int id, cshar, cpp, javascript, html, javaee, css, java;
		PreparedStatement pre;
		Scanner scanner = new Scanner(System.in);
		System.out.println("【ADD】[0]exit add func\n【ADD】[1]add user\n【ADD】[2]add student\n【ADD】[3]add scored\n");
		switch(scanner.nextInt()){
		case 0:
			return;
			
		case 1:
			System.out.println("【ADD】ID  PWD");
			String idd;
			conn = getCon();
			idd = scanner.next();
			pwd = scanner.next();
			sql = "insert into users values (?, ?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, idd);
			pre.setString(2, pwd);
			if(pre.executeUpdate() == 0){
				System.out.println("【ADD】Operate Failed");
				connClose(conn);
				break;
			}
			System.out.println("【ADD】Operate Successed");
			connClose(conn);
			break;
			
		case 2:
			System.out.println("【ADD】ID  NAME  GENDER  CLASS  DATE  REMARKS");
			id = scanner.nextInt();
			name = scanner.next();
			gender = scanner.next();
			classs = scanner.next();
			date = scanner.next();
			remarks = scanner.next();
			sql = "insert into student values (?, ?, ?, ?, ?, ?)";
			conn = getCon();
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			pre.setString(2, name);
			pre.setString(3, gender);
			pre.setString(4, classs);
			pre.setString(5, date);
			pre.setString(6, remarks);
			if(pre.executeUpdate() == 0){
				System.out.println("【ADD】Operate Failed");
				connClose(conn);
				break;
			}
			System.out.println("【ADD】Operate Successed");
			connClose(conn);
			break;
		case 3:
			System.out.println("【ADD】ID  NAME  CSHARP  CPP  JAVASCRIPT  HTML  JAVAEE  CSS  JAVA");
			conn = getCon();//
			id = scanner.nextInt();//1
			name = scanner.next();//2
			cshar = scanner.nextInt();//3
			cpp = scanner.nextInt();//4
			javascript = scanner.nextInt();//5
			html = scanner.nextInt();//6
			javaee = scanner.nextInt();//7
			css = scanner.nextInt();//8
			java = scanner.nextInt();//9
			sql = "insert into stu_score values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			pre.setString(2, name);
			pre.setInt(3, cshar);
			pre.setInt(4, cpp);
			pre.setInt(5, javascript);
			pre.setInt(6, html);
			pre.setInt(7, javaee);
			pre.setInt(8, css);
			pre.setInt(9, java);
			if(pre.executeUpdate() == 0){
				System.out.println("【ADD】Operate Failed");
				connClose(conn);
				break;
			}
			System.out.println("【ADD】Operate Successed");
			connClose(conn);
			break;
			
		default :
			System.out.println("【ADD】Wrong Input Number");
			break;
		}
	}
	
	//delete func
	public static void delete() throws Exception{
		int id;
		String name, sql, pwd;
		Connection conn;
		PreparedStatement pr;
		ResultSet rs;
		Scanner scanner = new Scanner(System.in);
		System.out.println("【DELETE】[0] exit\n【DELETE】[1] users delete\n【DELETE】[2] student delete\n【DELETE】[3] stu_score delete");
		switch (scanner.nextInt()) {//1 start
		case 0 ://1 exit
			return;
		case 1 :
			conn = getCon();
			sql = "select * from users where id = ?";
			pr = conn.prepareStatement(sql);
			System.out.print("【QUERY】[1] id: ");
			id = scanner.nextInt();
			pr.setInt(1, id);
			rs = pr.executeQuery();
			while(rs.next()){
				System.out.println("eventuate: id: " + rs.getInt("ID") + "\tpwd: " + rs.getString("PWD"));
			}
			sql = "delete from users where id = ?";
			pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			if(pr.executeUpdate() == 0){
				System.out.println("delete failed");
			}else{
				System.out.println("delete successed");
			}
			conn.close();
			break;
		case 2 :
			conn = getCon();
			sql = "select * from users where id = ?";
			pr = conn.prepareStatement(sql);
			System.out.print("【QUERY】[2] id: ");
			id = scanner.nextInt();
			pr.setInt(1, id);
			rs = pr.executeQuery();
			while(rs.next()){
				System.out.println("eventuate: 1.id: " + rs.getInt("id") + "\t2.name: " + rs.getString("name") + "\t3.gender: " + rs.getString("gender") + "\t4.class: " + rs.getString("class") + "\t5.date: " + rs.getString("datee") + "\t6.remarks: " + rs.getString("remarks"));
			}
			sql = "delete from users where id = ?";
			pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			if(pr.executeUpdate() == 0){
				System.out.println("delete failed");
			}else{
				System.out.println("delete successed");
			}
			conn.close();
			break;
		case 3 :
			conn = getCon();
			sql = "select * from student where id = ?";
			pr = conn.prepareStatement(sql);
			System.out.print("【QUERY】[3] id: ");
			id = scanner.nextInt();
			pr.setInt(1, id);
			rs = pr.executeQuery();
			while(rs.next()){
				System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tcshap: " + rs.getInt("CSHAR") + "\tcpp: " + rs.getInt("CPP") + "\tjavascript: " + rs.getInt("JAVASCRIPT") + "\thtml: " + rs.getInt("HTML") + "\tjavaee: " + rs.getInt("JAVAEE") + "\tcss: " + rs.getInt("CSSS") + "\tjava: " + rs.getInt("JAVA"));
			}
			sql = "delete from stu_score where id = ?";
			pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			if(pr.executeUpdate() == 0){
				System.out.println("delete failed");
			}else{
				System.out.println("delete successed");
			}
			conn.close();
			break;
		default :
			System.out.println("【ADD】Wrong Input Number");
			break;
		}
	}
	
	//query func3
	
	public static void query() throws Exception{
		int id;
		String name, sql, pwd;
		Connection conn;
		PreparedStatement pr;
		ResultSet rs;
		Scanner scanner = new Scanner(System.in);
		System.out.println("【QUERY】[0]exit\n【QUERY】[1]view table\n【QUERY】[2]exact query\n【QUERY】[3]indistinct query\n");
		switch (scanner.nextInt()) {//1 start
		case 0://1 exit
			return;
		case 1://1 view table
			System.out.println("【QUERY】[1][0]exit\n【QUERY】[1][1]table users\n【QUERY】[1][2]table student\n【QUERY】[1][3]table score\n");
			switch(scanner.nextInt()){
			case 0 :
				return;
			case 1 :
				conn = getCon();
				sql = "select * from users";
				pr = conn.prepareStatement(sql);
				rs = pr.executeQuery();
				while(rs.next()){
					System.out.println("eventuate: id: " + rs.getInt("ID") + "\tpwd: " + rs.getString("PWD"));
				}
				conn.close();
				break;
			case 2 :
				conn = getCon();
				sql = "select * from student";
				pr = conn.prepareStatement(sql);
				rs = pr.executeQuery();
				while(rs.next()){
					System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tgender: " + rs.getString("gender") + "\tclass: " + rs.getString("class") + "\tdate: " + rs.getString("datee") + "\tremarks: " + rs.getString("remarks"));
				}
				conn.close();
				break;
			case 3 :
				conn = getCon();
				sql = "select * from stu_score";
				pr = conn.prepareStatement(sql);
				rs = pr.executeQuery();
				while(rs.next()){
					System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tcshap: " + rs.getInt("CSHAR") + "\tcpp: " + rs.getInt("CPP") + "\tjavascript: " + rs.getInt("JAVASCRIPT") + "\thtml: " + rs.getInt("HTML") + "\tjavaee: " + rs.getInt("JAVAEE") + "\tcss: " + rs.getInt("CSSS") + "\tjava: " + rs.getInt("JAVA"));
				}
				conn.close();
				break;
			default :
				System.out.println("【QUERY】wrong input number");
				break;
			}
			break;
		case 2://1 exat query
			System.out.println("【QUERY】[2][0]exit\n【QUERY】[2][1]table users\n【QUERY】[2][2]table student\n【QUERY】[2][3]table score\n");
			switch (scanner.nextInt()) {//2 s
			case 0://2
				return;
			case 1://2
				System.out.println("【QUERY】[2][1][0]exit\n【QUERY】[2][1][1]query by id\n【QUERY】[2][1][2]query by name\n");
				switch (scanner.nextInt()) {//3 s
				case 0 :
					return;
				case 1 ://3
					conn = getCon();
					sql = "select * from users where id = ?";
					pr = conn.prepareStatement(sql);
					System.out.print("【QUERY】[2][1][1] id: ");
					id = scanner.nextInt();
					pr.setInt(1, id);
					rs = pr.executeQuery();
					while(rs.next()){
						System.out.println("eventuate: id: " + rs.getInt("ID") + "\tpwd: " + rs.getString("PWD"));
					}
					conn.close();
					break;
				case 2 ://3
					conn = getCon();
					sql = "select * from users where pwd = ?";
					pr = conn.prepareStatement(sql);
					System.out.print("【QUERY】[2][1][2] pwd: ");
					pwd = scanner.next();
					pr.setString(1, pwd);
					rs = pr.executeQuery();
					while(rs.next()){
						System.out.println("eventuate: id: " + rs.getInt("id") + "\tpwd: " + rs.getString("pwd"));
					}
					conn.close();
					break;
				default:
					System.out.println("【QUERY】wrong input number");
					break;
				}//3 end
				break;
			case 2://2
				System.out.println("【QUERY】[2][2][0]exit\n【QUERY】[2][2][1]query by id\n【QUERY】[2][2][2]query by name\n");
				switch (scanner.nextInt()) {//3 s
				case 0 :
					return;
				case 1 ://3
					conn = getCon();
					sql = "select * from student where id = ?";
					pr = conn.prepareStatement(sql);
					System.out.print("【QUERY】[2][2][1] id: ");
					id = scanner.nextInt();
					pr.setInt(1, id);
					rs = pr.executeQuery();
					while(rs.next()){
						System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tgender: " + rs.getString("gender") + "\tclass: " + rs.getString("class") + "\tdate: " + rs.getString("datee") + "\tremarks: " + rs.getString("remarks"));
					}
					conn.close();
					break;
				case 2 ://3
					conn = getCon();
					sql = "select * from student where name = ?";
					pr = conn.prepareStatement(sql);
					System.out.print("【QUERY】[2][2][2] name: ");
					name = scanner.next();
					pr.setString(1, name);
					rs = pr.executeQuery();
					while(rs.next()){
						System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tgender: " + rs.getString("gender") + "\tclass: " + rs.getString("class") + "\tdate: " + rs.getString("datee") + "\tremarks: " + rs.getString("remarks"));
					}
					conn.close();
					break;
				default:
					System.out.println("【QUERY】wrong input number");
					break;
				}//3 end
				break;
			case 3://2
				System.out.println("【QUERY】[2][3][0]exit\n【QUERY】[2][3][1]query by id\n【QUERY】[2][3][2]query by name\n");
				switch (scanner.nextInt()) {//3 s
				case 0 :
					return;
				case 1 ://3
					conn = getCon();
					sql = "select * from stu_score where id = ?";
					pr = conn.prepareStatement(sql);
					System.out.print("【QUERY】[2][3][1] id: ");
					id = scanner.nextInt();
					pr.setInt(1, id);
					rs = pr.executeQuery();
					while(rs.next()){
						System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tcshap: " + rs.getInt("CSHAR") + "\tcpp: " + rs.getInt("CPP") + "\tjavascript: " + rs.getInt("JAVASCRIPT") + "\thtml: " + rs.getInt("HTML") + "\tjavaee: " + rs.getInt("JAVAEE") + "\tcss: " + rs.getInt("CSSS") + "\tjava: " + rs.getInt("JAVA"));
					}
					conn.close();
					break;
				case 2 ://3
					conn = getCon();
					sql = "select * from stu_score where name = ?";
					pr = conn.prepareStatement(sql);
					System.out.print("【QUERY】[2][3][2] name: ");
					name = scanner.next();
					pr.setString(1, name);
					rs = pr.executeQuery();
					while(rs.next()){
						System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tcshap: " + rs.getInt("CSHAR") + "\tcpp: " + rs.getInt("CPP") + "\tjavascript: " + rs.getInt("JAVASCRIPT") + "\thtml: " + rs.getInt("HTML") + "\tjavaee: " + rs.getInt("JAVAEE") + "\tcss: " + rs.getInt("CSSS") + "\tjava: " + rs.getInt("JAVA"));
					}
					conn.close();
					break;
				default:
					System.out.println("【QUERY】wrong input number");
					break;
				}//3 end
				break;
			default:
				
				break;
			}//2 end
			break;
		case 3://1 distinct query
			System.out.println("【QUERY】[3][0]exit\n【QUERY】[3][1]table users\n【QUERY】[3][2]table student\n【QUERY】[3][3]table score\n");
			switch(scanner.nextInt()){
			case 0 :
				return;
			case 1 :
				conn = getCon();
				System.out.print("【QUERY】[3][1][1] id: ");
				id = scanner.nextInt();
				sql = "select * from users where id like '%" + id + "%'";
				pr = conn.prepareStatement(sql);
				rs = pr.executeQuery();
				while(rs.next()){
					System.out.println("eventuate: id: " + rs.getInt("ID") + "\tpwd: " + rs.getString("PWD"));
				}
				conn.close();
				break;
			case 2 :
				conn = getCon();
				System.out.print("【QUERY】[3][2][1] name: ");
				name = scanner.next();
				sql = "select * from student where name like '%" + name + "%'";
				pr = conn.prepareStatement(sql);
				rs = pr.executeQuery();
				while(rs.next()){
					System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tgender: " + rs.getString("gender") + "\tclass: " + rs.getString("class") + "\tdate: " + rs.getString("datee") + "\tremarks: " + rs.getString("remarks"));
				}
				conn.close();
				break;
			case 3 :
				conn = getCon();
				System.out.print("【QUERY】[3][3][1] name: ");
				name = scanner.next();
				sql = "select * from stu_score where name like '%" + name + "%'";
				pr = conn.prepareStatement(sql);
				rs = pr.executeQuery();
				while(rs.next()){
					System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tcshap: " + rs.getInt("CSHAR") + "\tcpp: " + rs.getInt("CPP") + "\tjavascript: " + rs.getInt("JAVASCRIPT") + "\thtml: " + rs.getInt("HTML") + "\tjavaee: " + rs.getInt("JAVAEE") + "\tcss: " + rs.getInt("CSSS") + "\tjava: " + rs.getInt("JAVA"));
				}
				conn.close();
				break;
			default :
				System.out.println("【QUERY】wrong input number");
				break;
			}
			break;
		default:
			System.out.println("【QUERY】wrong input number");
			break;
		}//1 end
	}
	
	//change func
	public static void change() throws Exception{
		PreparedStatement pr;
		ResultSet rs;
		Connection conn;
		String pwd, sql, name, gender, classs, date, remarks, setPwd, setGender, setClass, setDatee, setRemarks, setName;
		int id, cshar, cpp, javascript, html, javaee, css, java, setId, setCsharp, setCpp, setJavascript, setHtml, setJava, setCss, setJavaee;
		PreparedStatement pre;
		Scanner scanner = new Scanner(System.in);
		System.out.println("【CHANGE】[0] exit\n【CHANGE】[1] change user\n【CHANGE】[2] change student\n【CHANGE】[3] change scored");
		switch(scanner.nextInt()){
		case 0 :
			return;
		case 1 ://change users
			conn = getCon();
			sql = "select * from users where id = ?";
			pr = conn.prepareStatement(sql);
			System.out.print("【CHANGE】[1] index by id: ");
			id = scanner.nextInt();
			pr.setInt(1, id);
			rs = pr.executeQuery();
			while(rs.next()){// change users field
				System.out.println("eventuate: 1.id: " + rs.getInt("ID") + "\t2.pwd: " + rs.getString("PWD"));
				System.out.println("【CHANGE】[1][0] exit\n【CHANGE】[1][1] change users_id\n【CHANGE】[1][2] change users_pwd");
				switch (scanner.nextInt()) {
				case 0 :
					return;
				case 1 :
					System.out.print("input users_id :");
					setId = scanner.nextInt();
					sql = "update users set id = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setId);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");	
					}
					break;
				case 2 :
					System.out.print("input users_pwd :");
					setPwd = scanner.next();
					sql = "update users set pwd = ? where id = ?";
					pr.setString(1, setPwd);
					pr.setInt(2, id);
					pr = conn.prepareStatement(sql);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				default :
					System.out.println("【CHANGE】wrong input number");
					break;
				}
			}
			conn.close();
			break;
		case 2 ://3
			conn = getCon();
			sql = "select * from student where id = ?";
			pr = conn.prepareStatement(sql);
			System.out.print("【CHANGE】[2] index by id: ");
			id = scanner.nextInt();
			pr.setInt(1, id);
			rs = pr.executeQuery();
			while(rs.next()){
				System.out.println("eventuate: 1.id: " + rs.getInt("id") + "\t2.name: " + rs.getString("name") + "\t3.gender: " + rs.getString("gender") + "\t4.class: " + rs.getString("class") + "\t5.date: " + rs.getString("datee") + "\t6.remarks: " + rs.getString("remarks"));
				System.out.println("【CHANGE】[2][0]exit\n【CHANGE】[2][1] change student_id\n【CHANGE】[2][2] change student_name\n【CHANGE】[2][3] change student_gender\n【CHANGE】[2][4] change student_class\n【CHANGE】[2][5] change student_date\n【CHANGE】[2][6] change student_remarks\n");
				switch (scanner.nextInt()) {
				case 0 :
					return;
				case 1 :
					System.out.print("input student_id :");
					setId = scanner.nextInt();
					sql = "update student set id = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setId);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");	
					}
					break;
				case 2 :
					System.out.print("input student_name :");
					setName = scanner.next();
					sql = "update student set name = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setString(1, setName);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 3 :
					System.out.print("input student_gender :");
					setGender = scanner.next();
					sql = "update student set gender = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setString(1, setGender);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 4 :
					System.out.print("input student_class :");
					setClass = scanner.next();
					sql = "update student set class = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setString(1, setClass);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 5 :
					System.out.print("input student_datee :");
					setDatee = scanner.next();
					sql = "update student set datee = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setString(1, setDatee);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 6 :
					System.out.print("input student_remarks :");
					setRemarks = scanner.next();
					sql = "update student set remarks = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setString(1, setRemarks);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				default :
					System.out.println("【CHANGE】wrong input number");
					break;
				}
			}
			conn.close();
			break;
		case 3 ://3
			conn = getCon();
			sql = "select * from stu_score where id = ?";
			pr = conn.prepareStatement(sql);
			System.out.print("【CHANGE】[3] id: ");
			id = scanner.nextInt();
			pr.setInt(1, id);
			rs = pr.executeQuery();
			while(rs.next()){
				System.out.println("eventuate: id: " + rs.getInt("id") + "\tname: " + rs.getString("name") + "\tcshap: " + rs.getInt("CSHAR") + "\tcpp: " + rs.getInt("CPP") + "\tjavascript: " + rs.getInt("JAVASCRIPT") + "\thtml: " + rs.getInt("HTML") + "\tjavaee: " + rs.getInt("JAVAEE") + "\tcss: " + rs.getInt("CSSS") + "\tjava: " + rs.getInt("JAVA"));
				System.out.println("【CHANGE】[3][0]exit\n【CHANGE】[3][1] change stu_score_id\n【CHANGE】[3][2] change stu_score_name\n【CHANGE】[3][3] change stu_score_cshap\n【CHANGE】[3][4] change stu_score_cpp\n【CHANGE】[3][5] change stu_score_javascript\n【CHANGE】[3][6] change stu_score_html\n【CHANGE】[3][7] change stu_score_javaee\n【CHANGE】[3][8] change stu_score_css\n【CHANGE】[3][9] change stu_score_java");
				switch (scanner.nextInt()) {
				case 0 :
					return;
				case 1 :
					System.out.print("input stu_score_id :");
					setId = scanner.nextInt();
					sql = "update stu_score set id = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setId);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 2 :
					System.out.print("input stu_score_name :");
					setName = scanner.next();
					sql = "update stu_score set name = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setString(1, setName);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 3 :
					System.out.print("input stu_score_csharp :");
					setCsharp = scanner.nextInt();
					sql = "update stu_score set CSHAR = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setCsharp);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 4 :
					System.out.print("input stu_score_cpp :");
					setCpp = scanner.nextInt();
					sql = "update stu_score set CPP = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setCpp);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 5 :
					System.out.print("input stu_score_javascript :");
					setJavascript = scanner.nextInt();
					sql = "update stu_score set JAVASCRIPT = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setJavascript);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 6 :
					System.out.print("input stu_score_html :");
					setHtml = scanner.nextInt();
					sql = "update stu_score set HTML = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setHtml);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 7 :
					System.out.print("input stu_score_javaee :");
					setJavaee = scanner.nextInt();
					sql = "update stu_score set JAVAEE = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setJavaee);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 8 :
					System.out.print("input stu_score_css :");
					setCss = scanner.nextInt();
					sql = "update stu_score set CSSS = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setCss);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				case 9 :
					System.out.print("input stu_score_java :");
					setJava = scanner.nextInt();
					sql = "update stu_score set JAVA = ? where id = ?";
					pr = conn.prepareStatement(sql);
					pr.setInt(1, setJava);
					pr.setInt(2, id);
					if(pr.executeUpdate() == 0){
						System.out.println("change failed");
					}else{
						System.out.println("change successed");					
					}
					break;
				default :
					System.out.println("【CHANGE】wrong input number");
					break;
				}
			}
			conn.close();
			break;
		default :
			System.out.println("【CHANGE】wrong input number");
			break;
		}
	}
	





}

