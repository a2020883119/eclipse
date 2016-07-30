package day16.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import day16.dao.UsersDao;
import day16.db.DBCon;
import day16.entity.UsersEntity;

public class UsersDaoImpl implements UsersDao{
	UsersEntity usersIt;
	UsersEntity users;
	public UsersDaoImpl(){
		
	}
	@Override
	public void showData() {
		// TODO Auto-generated method stub
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
	public void insertData(UsersEntity users) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = null;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		showData();
		int id = getNextId();
		users.setId(id);
		String account = users.getAccount();
		String password = users.getPassword();
		try {
			sql = "insert into users values(?, ?, ?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.setString(2, account);
			st.setString(3, password);
			st.executeQuery();
			showData();
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updateData(UsersEntity users) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		String sql = null;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		showData();
		int id = users.getId();
		try {
			if(exists(users)){
				String account = users.getAccount();
				String password = users.getPassword();
				sql = "update users set password = ? , account = ? where id = ?";
				st = conn.prepareStatement(sql);
				st.setString(1, password);
				st.setString(2, account);
				st.setInt(3, id);
				st.executeUpdate();
				showData();
			}else{
				System.out.println("fail");
				showData();
			}
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteData(UsersEntity users) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = null;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		showData();
		int id = users.getId();
		try {
			if(exists(users)){
				sql = "delete users where id = ?";
				st = conn.prepareStatement(sql);
				st.setInt(1, id);
				st.executeUpdate();
				showData();
			}else{
				System.out.println("fail");
				showData();
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
	public void queryData(int id) {
		// TODO Auto-generated method stub
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		String sql = "select * from users where id = ? order by id";
		String account, password;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
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

	public boolean exists(UsersEntity users) {
		// TODO Auto-generated method stub
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		String sql = "select * from users where id = ? order by id";
		boolean flag = false;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, users.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				flag = true;
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public int getNextId(){
		int id = 0;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		try {
			String sql = "select count(*) from users";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				if(rs.getInt(1) != 0){
					sql = "select max(id) from users";
					st = conn.prepareStatement(sql);
					rs = st.executeQuery();
					while(rs.next()){
						id = rs.getInt(1);
					}
				}
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id++;
		return id;
	}
}
