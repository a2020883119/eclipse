package day20.dao;

import java.util.List;

import day20.entity.UsersEntity;

public interface UsersDao {
	public void showData();
	public int getNextId();
	public void queryData(int id);
	public boolean exists(UsersEntity users);
	public void insertData(UsersEntity users);
	public void updateData(UsersEntity users);
	public void deleteData(UsersEntity users);
	public Object sqlCurrencyOprate(String sql, List list);
}
