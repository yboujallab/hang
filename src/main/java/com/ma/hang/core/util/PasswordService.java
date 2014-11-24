package com.ma.hang.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import sun.misc.BASE64Encoder;

/**
 * @author yboujallab
 * class to hash password
 */
public final class PasswordService {

	private static PasswordService instance;

	private PasswordService() {
	}

	private synchronized String encrypt(String password) throws Exception {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA"); // step 2
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		}
		try {
			md.update(password.getBytes("UTF-8")); // step 3
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}

		byte raw[] = md.digest(); // step 4
		String hash = (new BASE64Encoder()).encode(raw); // step 5
		return hash; // step 6
	}

	/**
	 * @param password
	 * @return salt
	 * @throws Exception
	 */
	public synchronized String makeSalt(String password) throws Exception {
		try {
			StringBuffer salt = new StringBuffer();
			salt.append(Calendar.getInstance().getTimeInMillis());
			salt.append(password);
			return encrypt(salt.toString());
		} catch (Exception exp) {
			throw new Exception(exp.getMessage());
		}

	}

	/**
	 * @param password
	 * @param salt
	 * @return password encrypted
	 * @throws Exception
	 */
	public synchronized String encryptPassword(String password, String salt)
			throws Exception {
		try {
			StringBuffer strEncryptedPwd = new StringBuffer();
			strEncryptedPwd.append(salt.toString());
			strEncryptedPwd.append(password);
			return encrypt(strEncryptedPwd.toString());
		} catch (Exception exp) {
			throw new Exception(exp.getMessage());
		}
	}

	/**
	 * @return instance of the class
	 */
	public static synchronized PasswordService getInstance() // step 1
	{
		if (instance == null) {
			instance = new PasswordService();
		}
		return instance;
	}
}
