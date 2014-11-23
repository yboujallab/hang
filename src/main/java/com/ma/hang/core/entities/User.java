package com.ma.hang.core.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user", unique = true, nullable = false)
	private int idUser;

	@Column(name="email",unique=true)
	private String email;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String userLastname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_at")
	private Date modificationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date creationDate;
	
	@Column(name="encrypted_password")
	private String encryptedPassword;

	@Column(name="salt")
	private String salt;

	@Column(name="active")	
	private boolean isActivated;

	@Column(name="locked")	
	private boolean islocked;
	
	//bi-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name="id_profil")
	private Profil profil;

	public User() {
	}

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

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean getIslocked() {
		return islocked;
	}

	public void setIslocked(boolean islocked) {
		this.islocked = islocked;
	}

	
}