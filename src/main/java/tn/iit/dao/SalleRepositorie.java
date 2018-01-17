package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.entitie.Salle;
@Repository
public interface SalleRepositorie extends JpaRepository<Salle, Long> {
	@Query("SELECT count(c) FROM Salle c ")
	long count();
}
