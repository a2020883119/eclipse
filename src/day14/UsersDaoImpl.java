package day14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class UsersDaoImpl implements UsersDao{
	
	List<UsersEntity> usersList = new ArrayList<UsersEntity>();
	UsersEntity users = new UsersEntity();
	
	@Override
 	public void menu(){
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;
		while(exit){
			System.out.println("[0] exit\n[1] query\n[2] insert\n[3] delete\n[4] update\n[5] getuserslist\n[6] showuserslist\nplease in put number 0-5");
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
			case 5:
				getUsersList();
				break;
			case 6:
				showUsersList();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		queryData();
		System.out.println("for  example:101 account password");
		System.out.print("please input:");
		int id = scanner.nextInt();
		String account = scanner.next();
		String password = scanner.next();
		String sql = "select * from users where id = ?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(!rs.next()){
//				sql = "insert into users values(" + id + ", '" + account + "', '" + password + "')";
				sql = "insert into users values(?, ?, ?)";
				st = conn.prepareStatement(sql);
				st.setInt(1, id);
				st.setString(2, account);
				st.setString(3, password);
				if(st.executeUpdate() != 0){
					queryData();
				}
			}else{
				System.out.println("id = " + id + " exists");
				queryData();
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		queryData();
		System.out.println("for  example:101");
		System.out.print("please input:");
		int id = scanner.nextInt();
		int iddd = id;
//		String sql = "select * from users where id = " + id;
		String sql = "select * from users where id = ?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				System.out.print("input '0' to skip\n");
				System.out.print("please input id:");
				int idd = scanner.nextInt();
				if(!"0".equals(String.valueOf(idd)))
				{	
					sql = "select * from users where id = ?";
					st = conn.prepareStatement(sql);
					st.setInt(1, idd);
					rs = st.executeQuery();
					if(!rs.next()){
						db.safeClose(rs);
//						sql = "update users set id = " + idd + " where id = " + id;
						sql = "update users set id = ? where id = ?";
						st = conn.prepareStatement(sql);
						st.setInt(1, idd);
						st.setInt(2, id);
						st.executeUpdate();
						iddd = idd;
					}else{
						db.safeClose(rs);
						System.out.println("id = " + id + " exists");
						return;
					}
				}
				System.out.print("please input account:");
				String account = scanner.next();
				if(!"0".equals(account))
				{
//					sql = "update users set account = '" + account + "' where id = " + iddd;
					sql = "update users set account = ? where id = ?";
					st = conn.prepareStatement(sql);
					st.setString(1, account);
					st.setInt(2, iddd);
					st.executeUpdate();
				}
				System.out.print("please input password:");
				String password = scanner.next();
				if(!"0".equals(password))
				{
//					sql = "update users set password = '" + password + "' where id = " + iddd;
					sql = "update users set password = ? where id = ?";
					st = conn.prepareStatement(sql);
					st.setString(1, password);
					st.setInt(2, iddd);
					st.executeUpdate();
				}
				queryData();
			}else{
				System.out.println("id = " + id + " not exists");
				queryData();
			}
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		queryData();
		System.out.println("for  example:101");
		System.out.print("please input:");
		int id = scanner.nextInt();
//		String sql = "select * from users where id = " + id;
		String sql = "select * from users where id = ?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
//				sql = "delete users where id = " + id;
				sql = "delete users where id = ?";
				st = conn.prepareStatement(sql);
				st.setInt(1, id);
				if(st.executeUpdate() != 0){
					queryData();
				}
			}else{
				System.out.println("id = " + id + " not exists");
				queryData();
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void queryData() {
		// TODO Auto-generated method stub
		DBCon db = new DBCon();
		Connection conn = db.getConn();
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
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
 	public void showUsersList(){
		Iterator itUser = getUsersList().iterator();
		System.out.println();
		while(itUser.hasNext()){
			UsersEntity usersEn = (UsersEntity)itUser.next();
			System.out.println("\tid: "+usersEn.getId() + "\t\taccount: " + usersEn.getAccount() + "\t\tpassword: " + usersEn.getPassword());
		}
		System.out.println();
	}
	
	@Override
	public List<UsersEntity> getUsersList() {
		// TODO Auto-generated method stub
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		String sql = "select * from users order by id";
		int id = -1;
		int count = 0;
		String account, password;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
//			System.out.println("----------------------------------------------------------");
//			System.out.println("\tID\t\tACCOUNT\t\tPASSWORD\n");
			while(rs.next()){
				id = rs.getInt("id");
				account = rs.getString("account");
				password = rs.getString("password");
				users.setId(id);
				users.setAccount(account);
				users.setPassword(password);
				usersList.add(users);
//				System.out.println("\t" + id + "\t\t" + account + "\t\t" + password);
				count++;
			}
//			System.out.println("----------------------------------------------------------");
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(count);
		return usersList;
	}
	
}
