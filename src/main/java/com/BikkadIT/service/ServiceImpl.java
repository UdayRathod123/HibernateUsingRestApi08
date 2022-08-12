package com.BikkadIT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.dao.UserDaoI;
import com.BikkadIT.model.User;

@Service
public class ServiceImpl implements ServiceI {
@Autowired
	private UserDaoI userDaoI;
	@Override
	public int saveUserService(User user) {
		
		System.out.println("Service Layer");
		System.out.println(user);
		int id = userDaoI.saveUserDao(user);//service layer to DAO/persistence layer
		System.out.println(id);
		return id;
	}

	@Override
	public List<User> getAllUsersService() {
		List<User> list = userDaoI.getAllUsersDao();
		return list;
	}

	@Override
	public User loginCheck(User user) {
		User user1 = userDaoI.loginCheck(user);
		return user1;
	}
	@Override
	public User editUser(int uid) {
		User user = userDaoI.editUser(uid);
		
		return user;
	}
	@Override
	public User update(User user) {
		User user2 = userDaoI.update(user);
		return user2;
	}
	@Override
	public User delete(int uid) {
		User user = userDaoI.delete(uid);
		return user;
	}

}



