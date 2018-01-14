package tn.iit.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.iit.entities.Seance;
import tn.iit.entities.Creneau;

	@Repository
	public interface CreneauRepo extends JpaRepository<Creneau, Long> {
		@Query("SELECT c FROM Creneau c WHERE c.seance =:s and c.date =:d")
		List<Creneau> getCreneauBySeance(@Param("s") Seance seance, @Param("d") Date date);

		@Query("SELECT count(c) FROM Creneau c ")
		long count();

		@Modifying
		@Transactional
		@Query("Update Creneau c set c.etat=false where c.id=:id ")
		void annuler(@Param("id") Long id);
	}

