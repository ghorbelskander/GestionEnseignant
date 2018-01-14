package tn.iit.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.repo.ClasseRepo;
import tn.iit.entities.Classe;

@Controller
@RequestMapping("api/classe")
public class ClasseController {
	@Autowired
	private ClasseRepo classeRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	@ResponseBody
	public List<Classe> liste() {
		return classeRepo.findAll();

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		classeRepo.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	@ResponseBody
	public Classe get(@PathVariable Long id) {
		return classeRepo.findOne(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/")
	@ResponseBody
	public String createLanguage(@RequestBody Classe classe) {
		classeRepo.save(classe);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/")
	@ResponseBody
	public String editLanguage(@RequestBody Classe classe) {
		classeRepo.save(classe);
		return "success";
	}

}
