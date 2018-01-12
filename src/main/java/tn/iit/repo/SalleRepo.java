package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entities.Salle;

public interface SalleRepo extends JpaRepository<Salle, Long> {
		
}
