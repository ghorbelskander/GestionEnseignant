package tn.iit.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("api/creneau")
public class CreneauController {
	@Autowired
	private CreneauRepo creneauRepo;
	@Autowired
	private EnseignantRepo enseignantRepo;
	@Autowired
	private SalleRepo salleRepo;
	@Autowired
	private ClasseRepo classeRepo;
	@Autowired
	private SeanceRepo seanceRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	@ResponseBody
	public List<Creneau> liste() {
		return creneauRepo.findAll();

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		creneauRepo.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	@ResponseBody
	public Creneau get(@PathVariable Long id) {
		return creneauRepo.findOne(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/")
	@ResponseBody
	public String createCreneau(@RequestParam("idClasse") String idClasse,
			@RequestParam("idEnseignant") String idEnseignant, @RequestParam("idSalle") String idSalle,
			@RequestParam("idSeance") String idSeance) {

		Enseignant enseignant = enseignantRepo.getOne(Long.valueOf(idEnseignant));
		Classe classe = classeRepo.getOne(Long.valueOf(idClasse));
		Salle salle = salleRepo.getOne(Long.valueOf(idSalle));
		Seance seance = seanceRepo.getOne(Long.valueOf(idSeance));

		Creneau newCreneau = new Creneau(classe, enseignant, seance, salle, new Date().toString());
		newCreneau.setEtat(true);
		creneauRepo.save(newCreneau);
		

		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/creneauSeance/")
	@ResponseBody
	public List<Creneau> getCreneauBySeance(@RequestParam Long idSeance1, @RequestParam Date date,
			@PathVariable Long idSeance) {
		Seance seance = seanceRepo.findOne(idSeance);
		return creneauRepo.getCreneauBySeance(seance, date);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	@ResponseBody
	public String editLanguage(@RequestBody Creneau creneau) {
		creneauRepo.save(creneau);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/annuller/{id}")
	@ResponseBody
	public String annullerCreneau(@PathVariable Long id) {
		creneauRepo.annuler(id);
		
		return "success";
	}

}
