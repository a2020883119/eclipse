package day20;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import day20.entity.UsersEntity;
import day20.dao.impl.UsersDaoImpl;

public class UsersTest {

	public static void main(String[] args) {
//		UsersEntity users = new UsersEntity("111", "111");
//		UsersEntity users2 = new UsersEntity("222", "222");
//		UsersDaoImpl usersImpl = new UsersDaoImpl();
//	
//		System.out.println("¡¾insert¡¿");
//		usersImpl.insertData(users);
//		
//		System.out.println("¡¾updata¡¿");
//		users.setAccount("123");
//		users.setPassword("456");
//		usersImpl.updateData(users);
//		usersImpl.updateData(users2);
//		
//		System.out.println("¡¾query¡¿");
//		usersImpl.queryData(users.getId());
//		
//		System.out.println("¡¾delete¡¿");
//		usersImpl.deleteData(users);
//		usersImpl.deleteData(users2);
		
		UsersEntity users2 = new UsersEntity("222", "222");
		show();
		System.out.print("¡¾insert¡¿ ");
		testI(users2);
		show();
		System.out.print("¡¾query¡¿ ");
		testQ(users2);
		show();
		System.out.print("¡¾updata¡¿ ");
		testU(users2);
		show(); 
		System.out.print("¡¾delete¡¿ ");
		testD(users2);
		show();
	}
	
	public static void testQ(UsersEntity users){
		String sql = "select * from users where id = ?";
		List list = new ArrayList();
		UsersDaoImpl udi = new UsersDaoImpl();
		list.add(users.getId());
		ResultSet rs = (ResultSet)udi.sqlCurrencyOprate(sql, list);
		try {
			while(rs.next()){
				System.out.println("id:" + rs.getInt(1) + " account:" + rs.getString(2) + " password:" + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testI(UsersEntity users){
		String sql = "insert into users values(?, ?, ?)";
		List list = new ArrayList();
		UsersDaoImpl udi = new UsersDaoImpl();
		users.setId(udi.getNextId());
		list.add(users.getId());
		list.add(users.getAccount());
		list.add(users.getPassword());
		int rs = (Integer)udi.sqlCurrencyOprate(sql, list);
		System.out.println(rs);
	}
	public static void testU(UsersEntity users){
		String sql = "update users set account = ?, password = ? where id = ?";
		List list = new ArrayList();
		UsersDaoImpl udi = new UsersDaoImpl();
		list.add(users.getAccount());
		list.add(users.getPassword());
		list.add(users.getId());
		int rs = (Integer)udi.sqlCurrencyOprate(sql, list);
		System.out.println(rs);
	}
	public static void testD(UsersEntity users){
		String sql = "delete users where id = ?";
		List list = new ArrayList();
		UsersDaoImpl udi = new UsersDaoImpl();
		list.add(users.getId());
		int rs = (Integer)udi.sqlCurrencyOprate(sql, list);
		System.out.println(rs);
	}
	public static void show(){
		new day20.dao.impl.UsersDaoImpl().showData();
	}
}


















//test code
//String sql = "select * from users where name = ?";
//System.out.println(sql.indexOf("select"));
//System.out.println(sql.contains("select"));
//
//List list = new ArrayList();
//list.add("zhanghao");
//list.add("mima");
//list.add(1101);
//for(int i = 0; i < list.size(); i ++){
//	System.out.println(list.get(i));
//}
