package tn.iit.services;

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

import tn.iit.dao.GroupeRepositorie;
import tn.iit.entitie.Groupe;

@Controller
@RequestMapping("api/groupe")
@CrossOrigin(origins = "*")
public class GroupeController {
	@Autowired
	private GroupeRepositorie groupeRepositorie;

	@CrossOrigin(origins = "*")
	@GetMapping
	@ResponseBody
	public List<Groupe> liste() {
		return groupeRepositorie.findAll();

	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		groupeRepositorie.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	@ResponseBody
	public Groupe get(@PathVariable Long id) {
		return groupeRepositorie.findOne(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/")
	@ResponseBody
	public String createLanguage(@RequestBody Groupe groupe) {
		groupeRepositorie.save(groupe);
		return "success";
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/")
	@ResponseBody
	public String editLanguage(@RequestBody Groupe groupe) {
		groupeRepositorie.save(groupe);
		return "success";
	}

}
