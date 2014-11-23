package com.ma.hang.core.dao.impl;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dao.common.AbstractHibernateDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.util.PasswordHash;

/**
 * Profil DAO 
 * **/

@Repository
@Transactional
public class UserDao extends AbstractHibernateDao<User> implements
		IUserDao {
	 final static Logger logger = (Logger) LoggerFactory.getLogger(UserDao.class);
	
    @Autowired
    private IProfilDao profilDao;
	
	public UserDao() {
		super();
		setClazz(User.class);
	}
	@Override
	public boolean authenticate(String email, String submittedPassword) throws Exception {
		if(logger.isDebugEnabled())
				logger.debug("in authetication method");
		// TODO Auto-generated method stub
		if (email.isEmpty()) return false;
		User usr = findByEmail(email);
		if (usr != null){
			if(logger.isDebugEnabled())
				logger.debug("One user found with email :"+email);
			//check that the user is activated and not locked
			if (!usr.getIsActivated() || usr.getIslocked()) 
				return false;
			//encrypt password and check it to log in
			//String encryptedPwd = PasswordService.getInstance().encryptPassword(submittedPassword, usr.getSalt());
			boolean isPwdOk = PasswordHash.validatePassword(submittedPassword, usr.getEncryptedPassword());
			if (!isPwdOk) return false;
/*			StringBuilder query = new StringBuilder("from User ");
			query.append(" where email='"+email+"'");
			query.append(" and encryptedPassword='"+ encryptedPwd+ "'");
			Query result = getCurrentSession().createQuery(query.toString());
			if (result.list().isEmpty() || result.list().size() == 0 ) return false;
*/			if(logger.isDebugEnabled())
				logger.debug("user : "+ email+" authenticated");
			return true;
		}else{
			if(logger.isDebugEnabled())
				logger.debug("No user found with email :"+email);
			return false;
		}
	}

	@Override
	public User findByEmail(String email) {
		if(logger.isDebugEnabled())
			logger.debug("in findByEmail method");
		StringBuilder query = new StringBuilder("from User ");
		query.append(" where email='"+email+"'");
		Query result = getCurrentSession().createQuery(query.toString());
		return (User) result.list().get(0);
	}
	@Override
    public void createUser(UserDto userDto) throws Exception {
		if(logger.isDebugEnabled())
			logger.debug("in createUser method");

    	User userToAdd = new User();
    	Date now = Calendar.getInstance().getTime();
    	String salt=null;
    	String pwdEncrypted=null;
    	try {
	    	//salt generation
			//salt = PasswordService.getInstance().makeSalt(userDto.getPassword());
    		//encryption of password
			pwdEncrypted = PasswordHash.createHash(userDto.getPassword());
	    	//pwd generation
	        //pwdEncrypted = PasswordService.getInstance().encryptPassword(userDto.getPassword(), salt);

		} catch (Exception e) {
			if(logger.isErrorEnabled())
				logger.error("Error while creating user", e);
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
		if(logger.isDebugEnabled())
			logger.debug("End of createUser method");

    }
}
