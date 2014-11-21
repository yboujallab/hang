package com.ma.hang.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_profil")
	private int idProfil;

	@Column(name="profil_description")
	private String profilDescription;

	@Column(name="profil_name")
	private String profilName;


	public Profil() {
	}

	public int getIdProfil() {
		return this.idProfil;
	}

	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	public String getProfilDescription() {
		return this.profilDescription;
	}

	public void setProfilDescription(String profilDescription) {
		this.profilDescription = profilDescription;
	}

	public String getProfilName() {
		return this.profilName;
	}

	public void setProfilName(String profilName) {
		this.profilName = profilName;
	}


}