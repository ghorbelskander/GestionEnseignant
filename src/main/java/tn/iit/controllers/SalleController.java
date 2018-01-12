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

import tn.iit.entities.Salle;
import tn.iit.repo.SalleRepo;

@Controller
@RequestMapping("Salle")
public class SalleController {
	@Autowired
	private SalleRepo salleRepo;

	@GetMapping
	@ResponseBody
	public List<Salle> list() {
		return salleRepo.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		salleRepo.delete(id);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Salle show(@PathVariable Long id) {
		System.out.println(id);
		salleRepo.findOne(id);
		return salleRepo.findOne(id);
	}

	@ResponseBody
	@PostMapping
	public List<Salle> add(@RequestParam String nom, @RequestParam String etage, @RequestParam int capacite) {
		salleRepo.save(new Salle(nom,etage,capacite));
		return salleRepo.findAll();
	}

	@ResponseBody
	@PutMapping
	public void add(@RequestBody Salle salle) {
		salleRepo.save(salle);
	}
}
