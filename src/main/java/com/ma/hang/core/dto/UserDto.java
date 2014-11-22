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
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getUserLastname() {
		return userLastname;
	}
	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public int getIdprofil() {
		return idprofil;
	}
	public void setIdprofil(int idprofil) {
		this.idprofil = idprofil;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
