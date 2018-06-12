package tech.agiledev.spring4.crm.modele;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer nombreProduits;
	private Long montant;
	// volontairement je n'utilise pas Date & Time API
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNombreProduits() {
		return nombreProduits;
	}

	public void setNombreProduits(Integer nombreProduits) {
		this.nombreProduits = nombreProduits;
	}

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((montant == null) ? 0 : montant.hashCode());
		result = prime * result + ((nombreProduits == null) ? 0 : nombreProduits.hashCode());
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
		Commande other = (Commande) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (montant == null) {
			if (other.montant != null)
				return false;
		} else if (!montant.equals(other.montant))
			return false;
		if (nombreProduits == null) {
			if (other.nombreProduits != null)
				return false;
		} else if (!nombreProduits.equals(other.nombreProduits))
			return false;
		return true;
	}

}
