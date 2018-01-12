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
import tn.iit.repo.ClasseRepo;

@Controller
@RequestMapping("classe")
public class ClasseController {
	@Autowired
	private ClasseRepo classeRepo;

	@GetMapping
	@ResponseBody
	public List<Classe> list() {
		return classeRepo.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		classeRepo.delete(id);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Classe show(@PathVariable Long id) {
		System.out.println(id);
		classeRepo.findOne(id);
		return classeRepo.findOne(id);
	}

	@ResponseBody
	@PostMapping
	public List<Classe> add(@RequestParam String libelle, @RequestParam String specialite, @RequestParam String  niveau) {
		classeRepo.save(new Classe(libelle,specialite,niveau));
		return classeRepo.findAll();
	}

	@ResponseBody
	@PutMapping
	public void add(@RequestBody Classe classe) {
		classeRepo.save(classe);
	}
}
