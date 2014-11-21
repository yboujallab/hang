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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private int idUser;

	@Column(name="user_address")
	private String userAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="user_entrancedate")
	private Date userEntrancedate;

	@Column(name="user_firstname")
	private String userFirstname;

	@Column(name="user_lastname")
	private String userLastname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date user_modificationDate;

	//bi-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name="id_profil")
	private Profil profil;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getUserEntrancedate() {
		return this.userEntrancedate;
	}

	public void setUserEntrancedate(Date userEntrancedate) {
		this.userEntrancedate = userEntrancedate;
	}

	public String getUserFirstname() {
		return this.userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return this.userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public Date getUser_modificationDate() {
		return this.user_modificationDate;
	}

	public void setUser_modificationDate(Date user_modificationDate) {
		this.user_modificationDate = user_modificationDate;
	}

	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

}