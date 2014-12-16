package com.ma.hang.core.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "product_store")
@NamedQuery(name = "ProductStore.findAll", query = "SELECT p FROM ProductStore p")
@IdClass(ProductStorePK.class)
public class ProductStore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_product", unique = true, nullable = false)
	private Integer idProduct;
	
	@Id
	@Column(name = "id_store", unique = true, nullable = false)
	private Integer idStore;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at")
	private Date modifiedAt;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "arrived_at")
	private Date arrivedAt;
	
	@NotNull
	@Column(name = "qte")
	private Integer qte;
	
	@Column(name = "qte_min")
	private Integer qteMin;

	@Column(name = "amount")
	private Float amount;
	
	@Column(name = "comment")
	private String comment;
	
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public Integer getIdStore() {
		return idStore;
	}
	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public Date getArrivedAt() {
		return arrivedAt;
	}
	public void setArrivedAt(Date arrivedAt) {
		this.arrivedAt = arrivedAt;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public Integer getQteMin() {
		return qteMin;
	}
	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}