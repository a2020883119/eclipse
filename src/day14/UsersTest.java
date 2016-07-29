package day14;

import day14.entity.UsersEntity;
import day14.dao.impl.UsersDaoImpl;

public class UsersTest {

	public static void main(String[] args) {
		UsersEntity users = new UsersEntity(111, "132", "123");
		UsersDaoImpl usersImpl = new UsersDaoImpl(users);
		usersImpl.menu(users);
	}

}
