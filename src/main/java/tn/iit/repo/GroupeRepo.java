package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entities.Groupe;

public interface GroupeRepo extends JpaRepository<Groupe, Long> {
		
}
