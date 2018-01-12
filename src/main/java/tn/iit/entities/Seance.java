package tn.iit.entities;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Seance implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSeance;
	private String libelleSeance;
	private Date heureDebut;
	private Date heureFin;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seance")
	private Set<Creneau> creneaus = new HashSet<Creneau>(0);

	public Seance() {
	}

	public Seance(String libelleSeance, Date heureDebut, Date heureFin) {
		this.libelleSeance = libelleSeance;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	public Seance(String libelleSeance, Date heureDebut, Date heureFin, Set<Creneau> creneaus) {
		this.libelleSeance = libelleSeance;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.creneaus = creneaus;
	}

	

	
	public Integer getIdSeance() {
		return this.idSeance;
	}

	public void setIdSeance(Integer idSeance) {
		this.idSeance = idSeance;
	}

	
	public String getLibelleSeance() {
		return this.libelleSeance;
	}

	public void setLibelleSeance(String libelleSeance) {
		this.libelleSeance = libelleSeance;
	}

	public Date getHeureDebut() {
		return this.heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	
	public Date getHeureFin() {
		return this.heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	
	public Set<Creneau> getCreneaus() {
		return this.creneaus;
	}

	public void setCreneaus(Set<Creneau> creneaus) {
		this.creneaus = creneaus;
	}

	@Override
	public String toString() {
		return "Seance [idSeance=" + idSeance + ", libelleSeance=" + libelleSeance + ", heureDebut=" + heureDebut
				+ ", heureFin=" + heureFin + ", creneaus=" + creneaus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSeance == null) ? 0 : idSeance.hashCode());
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
		Seance other = (Seance) obj;
		if (idSeance == null) {
			if (other.idSeance != null)
				return false;
		} else if (!idSeance.equals(other.idSeance))
			return false;
		return true;
	}
	
}
