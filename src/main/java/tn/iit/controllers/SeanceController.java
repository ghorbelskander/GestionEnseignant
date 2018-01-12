package tn.iit.controllers;

import java.sql.Date;
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

import tn.iit.entities.Seance;
import tn.iit.repo.SeanceRepo;

@Controller
@RequestMapping("Seance")
public class SeanceController {
	@Autowired
	private SeanceRepo seanceRepo;

	@GetMapping
	@ResponseBody
	public List<Seance> list() {
		return seanceRepo.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		seanceRepo.delete(id);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Seance show(@PathVariable Long id) {
		System.out.println(id);
		seanceRepo.findOne(id);
		return seanceRepo.findOne(id);
	}

	@ResponseBody
	@PostMapping
	public List<Seance> add(@RequestParam String libelle, @RequestParam Date dateDebut, @RequestParam Date dateFin) {
		seanceRepo.save(new Seance(libelle, dateDebut, dateFin));
		return seanceRepo.findAll();
	}

	@ResponseBody
	@PutMapping
	public void add(@RequestBody Seance seance) {
		seanceRepo.save(seance);
	}
}
