package tech.agiledev.spring4.crm.modele;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PRENOM")
	private String prenom;
	
	@Column(name = "NOM")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "ADRESSE_ID")
	private Adresse adresse;
	
	@OneToMany
	@JoinColumn(name = "CLIENT_ID")
	private Set<Commande> commandes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Client other = (Client) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", commandes="
				+ commandes + "]";
	}

}
