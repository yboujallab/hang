package com.ma.hang.core.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
import com.ma.hang.core.dao.common.AbstractDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.exception.HangTechnicalException;
import com.ma.hang.core.util.PasswordHash;

/**
 * Profil DAO
 * **/

@Repository
@Transactional
public class UserDao extends AbstractDao<User> implements IUserDao {
	final static Logger logger = (Logger) LoggerFactory
			.getLogger(UserDao.class);

	@Autowired
	private IProfilDao profilDao;

	/**
	 * Constructor
	 */
	public UserDao() {
		super();
		setClazz(User.class);
	}

	@Override
	public User authenticate(String email, String submittedPassword)
			throws HangTechnicalException,NoSuchAlgorithmException, InvalidKeySpecException {
		if (email.isEmpty())
			return null;
		User usr = findByEmail(email);
		if (usr != null) {
			// check that the user is activated and not locked
			if (!usr.getIsActivated() || usr.getIslocked())
				return null;
			boolean isPwdOk = PasswordHash.validatePassword(submittedPassword,
					usr.getEncryptedPassword());
			if (!isPwdOk)
				return null;
			return usr;
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.ma.hang.core.dao.IUserDao#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		StringBuilder query = new StringBuilder("from User ");
		query.append(" where email='" + email + "'");
		Query result = getCurrentSession().createQuery(query.toString());
		if (result == null || result.list() == null || result.list().isEmpty()
				|| result.list().size() == 0 || result.list().size() > 1)
			return null;
		return (User) result.list().get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.ma.hang.core.dao.IUserDao#createUser(com.ma.hang.core.dto.UserDto)
	 */
	@Override
	public void createUser(UserDto userDto) throws HangTechnicalException {
		User userToAdd = new User();
		Date now = Calendar.getInstance().getTime();
		String salt = null;
		String pwdEncrypted = null;
		try {
			pwdEncrypted = PasswordHash.createHash(userDto.getPassword());
		} catch (Exception e) {
			if (logger.isErrorEnabled())
				logger.error("Error while creating user", e);
			throw new HangTechnicalException("Error while encryption password", e);
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
//		Profil profil = profilDao.findOne(userDto.getIdprofil());
//		userToAdd.set
		userToAdd.setProfil(userDto.getProfil());
		getCurrentSession().saveOrUpdate(userToAdd);
	}
}
