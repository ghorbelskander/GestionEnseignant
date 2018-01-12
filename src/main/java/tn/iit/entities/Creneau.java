package tn.iit.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Creneau implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_enseignant")
	private Enseignant enseignant;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_groupe")
	private Groupe groupe;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_salle")
	private Salle salle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_seance")
	private Seance seance;

	public Creneau() {
	}

	public Creneau(Enseignant enseignant, Groupe groupe, Salle salle, Seance seance) {
		this.enseignant = enseignant;
		this.groupe = groupe;
		this.salle = salle;
		this.seance = seance;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Salle getSalle() {
		return this.salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Seance getSeance() {
		return this.seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	@Override
	public String toString() {
		return "Creneau [id=" + id + ", enseignant=" + enseignant + ", groupe=" + groupe + ", salle=" + salle
				+ ", seance=" + seance + "]";
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
		Creneau other = (Creneau) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
