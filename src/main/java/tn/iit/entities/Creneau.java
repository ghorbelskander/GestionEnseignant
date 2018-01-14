package tn.iit.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Creneau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean etat;
	private String date;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Classe classe;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Enseignant enseignant;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Seance seance;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Salle salle;
	public Creneau(Long id, Classe classe, Enseignant enseignant, Seance seance, Salle salle,String date) {
		super();
		this.id = id;
		this.classe = classe;
		this.enseignant = enseignant;
		this.seance = seance;
		this.salle = salle;
		
		this.date=date;
	}
	public Creneau(Classe classe, Enseignant enseignant, Seance seance, Salle salle,String date) {
		super();
		this.classe = classe;
		
		this.enseignant = enseignant;
		this.seance = seance;
		this.salle = salle;
		this.date=date;
	}
	public boolean getEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Creneau() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Classe getNiveau() {
		return classe;
	}
	public void setNiveau(Classe groupe) {
		this.classe = groupe;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Creneau [id=" + id + ", classe=" + classe + ", enseignant=" + enseignant + ", seance=" + seance
				+ ", salle=" + salle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((salle == null) ? 0 : salle.hashCode());
		result = prime * result + ((seance == null) ? 0 : seance.hashCode());
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
		Creneau other = (Creneau) obj;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		if (seance == null) {
			if (other.seance != null)
				return false;
		} else if (!seance.equals(other.seance))
			return false;
		return true;
	}

}
