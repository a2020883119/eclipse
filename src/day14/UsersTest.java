package day14;

import day14.entity.UsersEntity;
import day14.dao.impl.UsersDaoImpl;

public class UsersTest {

	public static void main(String[] args) {
		UsersEntity users = new UsersEntity(111, "111", "111");
		UsersEntity users2 = new UsersEntity(222, "222", "222");
//		UsersDaoImpl usersImpl = new UsersDaoImpl(users);
		UsersDaoImpl usersImpl = new UsersDaoImpl();
//		usersImpl.menu(users);
	
		System.out.println("��insert��");
		usersImpl.insertData(users);
		usersImpl.insertData(users);
		
		System.out.println("��updata��");
		users.setAccount("123");
		users.setPassword("456");
		usersImpl.updateData(users);
		usersImpl.updateData(users2);
		
		System.out.println("��query��");
		usersImpl.queryData(users.getId());
		
		System.out.println("��delete��");
		usersImpl.deleteData(users);
		usersImpl.deleteData(users2);
		
	}

}
