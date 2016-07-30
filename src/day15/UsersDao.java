package day15;

import java.util.ArrayList;
import java.util.List;

public interface UsersDao {
	public void menu();
	public void queryData();
	public void insertData();
	public void updateData();
	public void deleteData();
	public void showUsersList();
	public List<UsersEntity> getUsersList();
}
