package com.ma.hang.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the profils database table.
 * 
 */
@Entity
@Table(name="profil")
@NamedQuery(name="Profil.findAll", query="SELECT p FROM Profil p")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_profil", unique = true, nullable = false)
	private int idProfil;

	@Column(name="profil_description")
	private String profilDescription;
	
	@NotNull
	@Column(name="profil_name")
	private String profilName;


	/**
	 * Constructor
	 */
	public Profil() {
	}

	/**
	 * @return profil id
	 */
	public int getIdProfil() {
		return this.idProfil;
	}

	/**
	 * @param idProfil
	 */
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	/**
	 * @return profil description
	 */
	public String getProfilDescription() {
		return this.profilDescription;
	}

	/**
	 * @param profilDescription
	 */
	public void setProfilDescription(String profilDescription) {
		this.profilDescription = profilDescription;
	}

	/** 
	 * @return profil name
	 */
	public String getProfilName() {
		return this.profilName;
	}

	/**
	 * @param profilName
	 */
	public void setProfilName(String profilName) {
		this.profilName = profilName;
	}


}