package tn.iit.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String etage;
	private int capacite;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "salle")
	private Set<Creneau> creneaus = new HashSet<Creneau>(0);

	public Salle() {
	}

	public Salle(String nom, String etage, int capacite) {
		this.nom = nom;
		this.etage = etage;
		this.capacite = capacite;
	}

	public Salle(String nom, String etage, int capacite, Set<Creneau> creneaus) {
		this.nom = nom;
		this.etage = etage;
		this.capacite = capacite;
		this.creneaus = creneaus;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtage() {
		return this.etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public int getCapacite() {
		return this.capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Set<Creneau> getCreneaus() {
		return this.creneaus;
	}

	public void setCreneaus(Set<Creneau> creneaus) {
		this.creneaus = creneaus;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", nom=" + nom + ", etage=" + etage + ", capacite=" + capacite + ", creneaus="
				+ creneaus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Salle other = (Salle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
