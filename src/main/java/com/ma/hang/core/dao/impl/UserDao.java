package com.ma.hang.core.dao.impl;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dao.common.AbstractHibernateDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.util.PasswordService;


/**
 * Profil DAO 
 * **/

@Repository
public class UserDao extends AbstractHibernateDao<User> implements
		IUserDao {

	
    @Autowired
    private IProfilDao profilDao;
	
	public UserDao() {
		super();
		setClazz(User.class);
	}

	@Override
	public boolean authenticate(String email, String submittedPassword) throws Exception {
		// TODO Auto-generated method stub
		User usr = findByEmail(email);
		if (usr != null){
			//check that the user is activated and not locked
			if (!usr.getIsActivated() || usr.getIslocked()) 
				return false;
			//encrypt password and check it to log in
			String encryptedPwd = PasswordService.getInstance().encryptPassword(submittedPassword, usr.getSalt());
			StringBuilder query = new StringBuilder("from User ");
			query.append(" where email='"+email+"'");
			query.append(" and encryptedPassword='"+ encryptedPwd+ "'");
			Query result = getCurrentSession().createQuery(query.toString());
			if (result.list().isEmpty() || result.list().size() == 0 ) return false;
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
	@Override
    public void createUser(UserDto userDto) throws Exception {
    	User userToAdd = new User();
    	Date now = Calendar.getInstance().getTime();
    	String salt=null;
    	String pwdEncrypted=null;
    	try {
	    	//salt generation
			salt = PasswordService.getInstance().makeSalt(userDto.getPassword());
	    	//pwd generation
	        pwdEncrypted = PasswordService.getInstance().encryptPassword(userDto.getPassword(), salt);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Error while encryption password",e);
		}
    	userToAdd.setCreationDate(now);
    	userToAdd.setEmail(userDto.getEmail());
    	userToAdd.setFirstname(userDto.getFirstname());
    	userToAdd.setUserLastname(userDto.getUserLastname());
    	userToAdd.setModificationDate(now);
    	userToAdd.setEncryptedPassword(pwdEncrypted);
    	userToAdd.setSalt(salt);
    	userToAdd.setModificationDate(now);
    	userToAdd.setIsActivated(true);
    	userToAdd.setIslocked(false);
    	userToAdd.setProfil(profilDao.findOne(userDto.getIdprofil()));
        getCurrentSession().saveOrUpdate(userToAdd);
    }
	
}
