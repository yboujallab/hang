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
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the stores database table.
 * 
 */
@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product", unique = true, nullable = false)
	private int idProduct;
	
	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "qte_min")
	private Integer qteMin;

	@NotNull
	@Column(name = "capacity")
	private Integer capacity;
	
	@NotNull
	@Column(name = "unity")
	private String unity;
	
	@NotNull
	@Column(name = "box_capacity")
	private Integer boxCapacity;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at")
	private Date modifiedAt;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	// bi-directional many-to-one association to Profil
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_supplier")
	private Supplier supplier;
	
	// bi-directional many-to-one association to Profil
/*	@NotNull
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_supplier")
	@JoinTable(name = "product_store", joinColumns = { 
			@JoinColumn(name = "id_product", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id_store", 
					nullable = false, updatable = false) })
	private Set<Store> stores = new HashSet<Store>(0);

	public*/ int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQteMin() {
		return qteMin;
	}

	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getBoxCapacity() {
		return boxCapacity;
	}

	public void setBoxCapacity(Integer boxCapacity) {
		this.boxCapacity = boxCapacity;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

/*	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}*/

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}
	
}