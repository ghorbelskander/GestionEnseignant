package tn.iit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.iit.entities.Seance;

@Repository
public interface SeanceRepo extends JpaRepository<Seance, Long> {

	@Query("SELECT c FROM Seance c WHERE c.libelleSeance like :libelleSeance ")
	public List<Seance> verif(@Param("libelleSeance") String liblelle);

	@Query("SELECT count(c) FROM Seance c ")
	long count();
}
