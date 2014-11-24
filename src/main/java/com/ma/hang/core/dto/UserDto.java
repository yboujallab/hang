package com.ma.hang.core.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * Bean to create user
 */
public class UserDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -682408009065206333L;

	private int idUser;
	private String email;
	private String firstname;
	private String password;
	private String userLastname;
	private Date modificationDate;
	private Date creationDate;
	private int idprofil;
	
	/**
	 * @return id user
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return email 
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return first name
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return last name
	 */
	public String getUserLastname() {
		return userLastname;
	}
	/**
	 * @param userLastname
	 */
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}
	/**
	 * @return modification date
	 */
	public Date getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	/**
	 * @return profil id
	 */
	public int getIdprofil() {
		return idprofil;
	}
	/**
	 * @param idprofil
	 */
	public void setIdprofil(int idprofil) {
		this.idprofil = idprofil;
	}
	/**
	 * @return creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
