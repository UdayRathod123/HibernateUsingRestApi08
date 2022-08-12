

package com.BikkadIT.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikkadIT.model.User;

@Repository
public class UserDaoImpl implements UserDaoI{

//	private UserDaoI userDaoI;
	
	@Autowired
	private SessionFactory sf;

	@Override
	public int saveUserDao(User user) {
		System.out.println("persiatance Layer");
		System.out.println(user);
		Session session = sf.openSession();
		session.beginTransaction();
		int id = (int) session.save(user);//count of no. of uses's data come to id and goes to userController loc 29
		System.out.println(id);
		session.getTransaction().commit();
		return id;
	}

	@Override
	public List<User> getAllUsersDao() {
		Session session = sf.openSession();
		String hql="from User";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		
		return list;
	}

	@Override
	public User loginCheck(User user) {
		Session session = sf.openSession();
		String hql="from User";
		Query query = session.createQuery(hql);
		List<User> list = query.getResultList();
		
		for(User user1:list)
		{
			if(user.getUname().equals(user1.getUname()) && (user.getUpwd().equals(user1.getUpwd())))
			{
				return user1;
			}
		
		}
		
		return null;
	}

	@Override
	public User editUser(int uid) {
		Session session = sf.openSession();
		User user = session.get(User.class, uid);
		
		
		return user;
	}

	@Override
	public User update(User user) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		User user2 = session2.get(User.class, user.getUid());
		session2.close();
		return user2;
		
	}

	@Override
	public User delete(int uid) {
		Session session = sf.openSession();
		session.beginTransaction();
		User user = session.get(User.class, uid);
		if(user!=null)
		{
			session.delete(user);
			session.getTransaction().commit();
			session.close();
		}
		return user;

	}
	
}

