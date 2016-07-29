package day14.dao;

import java.util.List;
import day14.entity.UsersEntity;

public interface UsersDao {
	public void menu(UsersEntity users);
	public void showData();
	public void queryData(int id);
	public void insertData(UsersEntity users);
	public void updateData(UsersEntity users);
	public void deleteData(UsersEntity users);
	public void showUsersList();
	public List<UsersEntity> getUsersList();
}
