package com.ma.hang.core.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.ma.hang.core.util.ExtendedEmailValidator;



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

	@NotNull
	@ExtendedEmailValidator
	@Column(name="email",unique=true)
	private String email;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="firstname")
	private String firstname;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="lastname")
	private String userLastname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_at")
	private Date modificationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date creationDate;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="encrypted_password")
	private String encryptedPassword;

	@Column(name="salt")
	private String salt;
	
	@NotNull
	@Column(name="active")	
	private boolean isActivated;

	@NotNull
	@Column(name="locked")	
	private boolean islocked;
	
	@NotNull
	@Column(name="expired")	
	private boolean expired;
	
	
	//bi-directional many-to-one association to Profil
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_profil")
	private Profil profil;
	
	//bi-directional many-to-one association to Profil
	@OneToMany(mappedBy="user")
	private List<Store> stores;
	
	//bi-directional many-to-one association to Profil
	@OneToMany(mappedBy="user")
	private List<Supplier> suppliers;

	/**
	 * Constructor
	 */
	public User() {
	}

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
	 * @return user last name
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
	 * @return encrypted password
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	/**
	 * @param encryptedPassword
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	/**
	 * @return salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * @param profil
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
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
	 * @return is activated
	 */
	public boolean getIsActivated() {
		return isActivated;
	}

	/**
	 * @param isActivated
	 */
	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	/**
	 * @return is locked
	 */
	public boolean getIslocked() {
		return islocked;
	}

	/**
	 * @param islocked
	 */
	public void setIslocked(boolean islocked) {
		this.islocked = islocked;
	}

	/**
	 * @return stores
	 */
	public List<Store> getStores() {
		return this.stores;
	}

	/**
	 * @param stores
	 */
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	/**
	 * @param store
	 * @return store added
	 */
	public Store addStore(Store store) {
		getStores().add(store);
		store.setUser(this);

		return store;
	}

	/**
	 * @param store
	 * @return store removed
	 */
	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setUser(null);

		return store;
	}

	public boolean getIsExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public boolean isExpired() {
		return expired;
	}
	
}