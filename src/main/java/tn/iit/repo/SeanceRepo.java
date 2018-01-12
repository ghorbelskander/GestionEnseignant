package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entities.Seance;

public interface SeanceRepo extends JpaRepository<Seance, Long> {
		
}
