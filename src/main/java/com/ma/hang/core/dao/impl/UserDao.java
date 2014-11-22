package com.ma.hang.core.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dao.common.AbstractHibernateDao;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.util.PasswordService;


/**
 * Profil DAO 
 * **/

@Repository
public class UserDao extends AbstractHibernateDao<User> implements
		IUserDao {

	public UserDao() {
		super();
		setClazz(User.class);
	}

	@Override
	public boolean authenticate(String email, String submittedPassword) throws Exception {
		// TODO Auto-generated method stub
		User usr = findByEmail(email);
		if (usr != null){
			String encryptedPwd = PasswordService.getInstance().encryptPassword(submittedPassword, usr.getSalt());
			StringBuilder query = new StringBuilder("from User ");
			query.append(" where email='"+email+"'");
			query.append(" and encryptedPassword='"+ encryptedPwd+ "'");
			Query result = getCurrentSession().createQuery(query.toString());
			if (result.list().isEmpty() || result.list().size() == 0) return false;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		StringBuilder query = new StringBuilder("from User ");
		query.append(" where email='"+email+"'");
		Query result = getCurrentSession().createQuery(query.toString());

		return (User) result.list().get(0);
	}

	
}
