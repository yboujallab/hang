package com.ma.hang.core.entities;

import java.io.Serializable;
/**
 * Primary key of product store
 * 
 * **/
public class ProductStorePK  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer idProduct;
	protected Integer idStore;

    public ProductStorePK() {}

    public ProductStorePK(Integer idProduct, Integer idStore) {
        this.idStore = idStore;
        this.idProduct = idProduct;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProduct == null) ? 0 : idProduct.hashCode());
		result = prime * result + ((idStore == null) ? 0 : idStore.hashCode());
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
		ProductStorePK other = (ProductStorePK) obj;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		if (idStore == null) {
			if (other.idStore != null)
				return false;
		} else if (!idStore.equals(other.idStore))
			return false;
		return true;
	}
    
    
    
    
}
