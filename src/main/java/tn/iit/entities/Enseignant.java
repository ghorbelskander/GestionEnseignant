package tn.iit.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enseignant implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String grade;
	private String institution;
	private String email;
	private String tel;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enseignant")
	private Set<Creneau> creneaus = new HashSet<Creneau>(0);

	public Enseignant() {
	}

	public Enseignant(String nom, String prenom, String grade, String institution, String email, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
		this.institution = institution;
		this.email = email;
		this.tel = tel;
	}

	public Enseignant(String nom, String prenom, String grade, String institution, String email, String tel,
			Set<Creneau> creneaus) {
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
		this.institution = institution;
		this.email = email;
		this.tel = tel;
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

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

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
		Enseignant other = (Enseignant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", grade=" + grade + ", institution="
				+ institution + ", email=" + email + ", tel=" + tel + ", creneaus=" + creneaus + "]";
	}

}
