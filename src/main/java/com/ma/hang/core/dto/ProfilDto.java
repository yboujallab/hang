package com.ma.hang.core.dto;

import java.io.Serializable;
/**
 * Bean for advanced search 
 */
public class ProfilDto implements Serializable{
	
	/**
	 * Generated uid
	 */
	private static final long serialVersionUID = -905387223096525562L;
	
	/**
	 * profil description
	 */
	private String profilDescription;

	/**profil name
	 * 
	 */
	private String profilName;

	/**
	 * @param profilDescription
	 * @param profilName
	 */
	public ProfilDto(String profilDescription, String profilName) {
		super();
		this.profilDescription = profilDescription;
		this.profilName = profilName;
	}
	
	

	/**
	 * 
	 */
	public ProfilDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return profil description
	 */
	public String getProfilDescription() {
		return profilDescription;
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
		return profilName;
	}

	/**
	 * @param profilName
	 */
	public void setProfilName(String profilName) {
		this.profilName = profilName;
	}

	@Override
	public String toString() {
		return "AdvancedSearchProfilBean [profilDescription="
				+ profilDescription + ", profilName=" + profilName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((profilDescription == null) ? 0 : profilDescription
						.hashCode());
		result = prime * result
				+ ((profilName == null) ? 0 : profilName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfilDto other = (ProfilDto) obj;
		if (profilDescription == null) {
			if (other.profilDescription != null)
				return false;
		} else if (!profilDescription.equals(other.profilDescription))
			return false;
		if (profilName == null) {
			if (other.profilName != null)
				return false;
		} else if (!profilName.equals(other.profilName))
			return false;
		return true;
	}
	
	
	
	
}
