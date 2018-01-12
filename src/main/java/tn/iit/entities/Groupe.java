package tn.iit.entities;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Groupe implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2753552080166799360L;
	private Integer id;
	private String libelle;
	private String specialite;
	private String niveau;
	private Set<Creneau> creneaus = new HashSet<Creneau>(0);

	public Groupe() {
	}

	public Groupe(String libelle, String specialite, String niveau) {
		this.libelle = libelle;
		this.specialite = specialite;
		this.niveau = niveau;
	}

	public Groupe(String libelle, String specialite, String niveau, Set<Creneau> creneaus) {
		this.libelle = libelle;
		this.specialite = specialite;
		this.niveau = niveau;
		this.creneaus = creneaus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "libelle", nullable = false, length = 30)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name = "specialite", nullable = false, length = 30)
	public String getspecialite() {
		return this.specialite;
	}

	public void setspecialite(String specialite) {
		this.specialite = specialite;
	}

	@Column(name = "niveau", nullable = false, length = 30)
	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupe")
	public Set<Creneau> getCreneaus() {
		return this.creneaus;
	}

	public void setCreneaus(Set<Creneau> creneaus) {
		this.creneaus = creneaus;
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
		Groupe other = (Groupe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Groupe [id=" + id + ", libelle=" + libelle + ", specialite=" + specialite + ", niveau=" + niveau
				+ ", creneaus=" + creneaus + "]";
	}

}
