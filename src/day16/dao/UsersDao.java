package day16.dao;

import day16.entity.UsersEntity;

public interface UsersDao {
	public void showData();
	public void queryData(int id);
	public void insertData(UsersEntity users);
	public void updateData(UsersEntity users);
	public void deleteData(UsersEntity users);
}
