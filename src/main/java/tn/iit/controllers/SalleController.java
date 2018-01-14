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

import tn.iit.entities.Salle;
import tn.iit.repo.SalleRepo;

@Controller
@RequestMapping("api/salle")
public class SalleController {
	@Autowired
	private SalleRepo salleRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	@ResponseBody
	public List<Salle> liste() {
		return salleRepo.findAll();

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		salleRepo.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	@ResponseBody
	public Salle get(@PathVariable Long id) {
		return salleRepo.findOne(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/")
	@ResponseBody
	public String createLanguage(@RequestBody Salle salle) {

		salleRepo.save(salle);

		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/")
	@ResponseBody
	public String editSalle(@RequestBody Salle salle) {

		salleRepo.save(salle);
		return "success";
	}

}
