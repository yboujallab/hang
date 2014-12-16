package com.ma.hang.core.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the stores database table.
 * 
 */
@Entity
@Table(name = "store")
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
public class Store implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_store", unique = true, nullable = false)
	private int idStore;
	
	@NotNull
	@Column(name = "name")
	private String storeName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "description")
	private String storeDescription;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "address_line_1")
	private String storeAddressFirstLine;

	@Column(name = "address_line_2")
	private String storeAddressSecondLine;
	
	@NotNull
	@Column(name = "surface")
	private float surface;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at")
	private Date modifiedAt;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "country")
	private String country;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "city")
	private String city;
	
	@Column(name = "post_code")
	private Integer postCode;
	
	
	// bi-directional many-to-one association to Profil
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	
/*	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "stores")
	private Set<Product> products = new HashSet<Product>(0);*/
	
	/**
	 * Constructor
	 */
	public Store() {
	}

	/**
	 * @return store id
	 */
	public int getIdStore() {
		return idStore;
	}

	/**
	 * @param idStore
	 */
	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}

	/**
	 * @return store name
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @return stroe description
	 */
	public String getStoreDescription() {
		return storeDescription;
	}

	/**
	 * @param storeDescription
	 */
	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	/**
	 * @return address line 1
	 */
	public String getStoreAddressFirstLine() {
		return storeAddressFirstLine;
	}

	/**
	 * @param storeAddressFirstLine
	 */
	public void setStoreAddressFirstLine(String storeAddressFirstLine) {
		this.storeAddressFirstLine = storeAddressFirstLine;
	}

	/**
	 * @return store adress
	 */
	public String getStoreAddressSecondLine() {
		return storeAddressSecondLine;
	}

	/**
	 * @param storeAddressSecondLine
	 */
	public void setStoreAddressSecondLine(String storeAddressSecondLine) {
		this.storeAddressSecondLine = storeAddressSecondLine;
	}

	/**
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return poste code
	 */
	public Integer getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 */
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the surface
	 */
	public float getSurface() {
		return surface;
	}

	/**
	 * @param surface
	 */
	public void setSurface(float surface) {
		this.surface = surface;
	}

	/**
	 * @return modification date
	 */
	public Date getModifiedAt() {
		return modifiedAt;
	}

	/**
	 * @param modifiedAt
	 */
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	/**
	 * @return creation date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return user 
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

/*	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}*/

}