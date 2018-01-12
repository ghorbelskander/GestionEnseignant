package tn.iit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.entities.Classe;
import tn.iit.entities.Creneau;
import tn.iit.entities.Enseignant;
import tn.iit.entities.Salle;
import tn.iit.entities.Seance;
import tn.iit.repo.ClasseRepo;
import tn.iit.repo.CreneauRepo;
import tn.iit.repo.EnseignantRepo;
import tn.iit.repo.SalleRepo;
import tn.iit.repo.SeanceRepo;

@Controller
@RequestMapping("creneau")
public class CreneauController {
	@Autowired
	private CreneauRepo creneauRepo;
	@Autowired
	private EnseignantRepo enseignantRepo;
	@Autowired
	private SeanceRepo seanceRepo;
	@Autowired
	private SalleRepo salleRepo;
	@Autowired
	private ClasseRepo classeRepo;

	@GetMapping
	@ResponseBody
	public List<Creneau> list() {
		return creneauRepo.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		creneauRepo.delete(id);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Creneau show(@PathVariable Long id) {
		System.out.println(id);
		seanceRepo.findOne(id);
		return creneauRepo.findOne(id);
	}

	@ResponseBody
	@PostMapping
	public List<Creneau> add(@RequestParam Enseignant enseignant, @RequestParam Classe classe, @RequestParam Salle salle, @RequestParam Seance seance) {
		creneauRepo.save(new Creneau(enseignant,classe,salle,seance));
		return creneauRepo.findAll();
	}

	@ResponseBody
	@PutMapping
	public void add(@RequestBody Creneau creneau) {
		creneauRepo.save(creneau);
	}
}
