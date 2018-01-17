package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.entitie.Groupe;
@Repository
public interface GroupeRepositorie extends JpaRepository<Groupe, Long> {
	@Query("SELECT count(c) FROM Groupe c ")
	long count();
}
