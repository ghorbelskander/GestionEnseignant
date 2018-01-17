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

import tn.iit.entities.Enseignant;
import tn.iit.repo.EnseignantRepo;

@Controller
@RequestMapping("api/enseignant")
public class EnseignantController {
	@Autowired
	private EnseignantRepo enseignantRepo;

	@CrossOrigin(origins = "*")
	@GetMapping
	@ResponseBody
	public List<Enseignant> liste() {
		return enseignantRepo.findAll();

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		enseignantRepo.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	@ResponseBody
	public Enseignant get(@PathVariable Long id) {
		return enseignantRepo.findOne(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/")
	@ResponseBody
	public String createEnsignat(@RequestBody Enseignant user) {
		enseignantRepo.save(user);
		return "success";
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/")
	@ResponseBody
	public String editEnseignant(@RequestBody Enseignant user) {
		Enseignant e = user;
		enseignantRepo.save(e);
		return "success";
	}

}
