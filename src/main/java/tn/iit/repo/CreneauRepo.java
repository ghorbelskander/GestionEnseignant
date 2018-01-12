package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entities.Creneau;

public interface CreneauRepo extends JpaRepository<Creneau, Long> {
		
}
