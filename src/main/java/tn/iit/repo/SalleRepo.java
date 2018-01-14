package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.entities.Salle;
@Repository
public interface SalleRepo extends JpaRepository<Salle, Long> {
	@Query("SELECT count(c) FROM Salle c ")
	long count();
}
