package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.entities.Classe;
@Repository
public interface ClasseRepo extends JpaRepository<Classe, Long> {
	@Query("SELECT count(c) FROM Groupe c ")
	long count();
}
