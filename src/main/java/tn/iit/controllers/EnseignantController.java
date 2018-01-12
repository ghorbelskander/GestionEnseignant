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

import tn.iit.entities.Enseignant;
import tn.iit.repo.EnseignantRepo;

@Controller
@RequestMapping("Enseignant")
public class EnseignantController {
	@Autowired
	private EnseignantRepo enseignantRepo;

	@GetMapping
	@ResponseBody
	public List<Enseignant> list() {
		return enseignantRepo.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		enseignantRepo.delete(id);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Enseignant show(@PathVariable Long id) {
		System.out.println(id);
		enseignantRepo.findOne(id);
		return enseignantRepo.findOne(id);
	}

	@ResponseBody
	@PostMapping
	public List<Enseignant> add(@RequestParam String nom, @RequestParam String prenom, @RequestParam String grade,
			@RequestParam String institution, @RequestParam String mail, @RequestParam String tel) {
		enseignantRepo.save(new Enseignant(nom,prenom,grade,institution,mail,tel));
		return enseignantRepo.findAll();
	}
	@ResponseBody
	 @PutMapping
	 public void  add(@RequestBody Enseignant enseignant)
	 {
		 enseignantRepo.save(enseignant);
	 }
}
