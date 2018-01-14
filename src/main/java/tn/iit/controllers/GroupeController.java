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

import tn.iit.repo.GroupeRepo;
import tn.iit.entities.Groupe;

@Controller
@RequestMapping("api/groupe")
public class GroupeController {
	@Autowired
	private GroupeRepo groupeRepositorie;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	@ResponseBody
	public List<Groupe> liste() {
		return groupeRepositorie.findAll();

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		groupeRepositorie.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	@ResponseBody
	public Groupe get(@PathVariable Long id) {
		return groupeRepositorie.findOne(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/")
	@ResponseBody
	public String createLanguage(@RequestBody Groupe groupe) {
		groupeRepositorie.save(groupe);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/")
	@ResponseBody
	public String editLanguage(@RequestBody Groupe groupe) {
		groupeRepositorie.save(groupe);
		return "success";
	}

}
