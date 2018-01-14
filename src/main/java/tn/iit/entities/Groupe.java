package tn.iit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Groupe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle ;
	private String specialite ;
	private String niveau ;
	public Groupe(Long id, String libelle, String specialite, String niveau) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.specialite = specialite;
		this.niveau = niveau;
	}
	public Groupe(String libelle, String specialite, String niveau) {
		super();
		this.libelle = libelle;
		this.specialite = specialite;
		this.niveau = niveau;
	}
	public Groupe() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getspecialite() {
		return specialite;
	}
	public void setspecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Groupe [id=" + id + ", libelle=" + libelle + ", specialite=" + specialite + ", niveau=" + niveau + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((specialite == null) ? 0 : specialite.hashCode());
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
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (specialite == null) {
			if (other.specialite != null)
				return false;
		} else if (!specialite.equals(other.specialite))
			return false;
		return true;
	}

}
