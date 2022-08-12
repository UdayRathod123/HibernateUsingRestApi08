
package com.BikkadIT.dao;

import java.util.List;

import com.BikkadIT.model.User;

public interface UserDaoI {

	public int saveUserDao(User user);

	public List<User> getAllUsersDao();
	
	public User loginCheck(User user);

	public User editUser(int uid);
	
	public User update(User user);
	
	public User delete(int uid);
}
