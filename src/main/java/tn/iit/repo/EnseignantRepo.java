package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.entities.Enseignant;
@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {
	@Query("SELECT count(c) FROM Enseignant c ")
	long count();
}
