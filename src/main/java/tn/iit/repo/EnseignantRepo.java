package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entities.Enseignant;

public interface EnseignantRepo extends JpaRepository<Enseignant, Long> {
		
}
