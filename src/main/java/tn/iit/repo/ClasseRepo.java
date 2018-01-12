package tn.iit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entities.Classe;

public interface ClasseRepo extends JpaRepository<Classe, Long> {
		
}
