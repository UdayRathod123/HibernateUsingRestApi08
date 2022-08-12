package com.BikkadIT.service;


import java.util.List;

import com.BikkadIT.model.User;
public interface ServiceI {
	
	
public int saveUserService(User user);
	
	public List<User> getAllUsersService();
	
	public User loginCheck(User user);
	
	public User editUser(int uid);
	
	public User update(User user);
	
	public User delete(int uid);
}


