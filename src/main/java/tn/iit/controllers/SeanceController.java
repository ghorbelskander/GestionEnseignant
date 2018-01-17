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

import tn.iit.repo.SeanceRepo;
import tn.iit.entities.Seance;

@Controller
@RequestMapping("api/seance")
public class SeanceController {
	@Autowired
	private SeanceRepo seanceRepo;

	@CrossOrigin(origins = "*")
	@GetMapping
	@ResponseBody
	public List<Seance> liste() {
		return seanceRepo.findAll();

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		seanceRepo.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	@ResponseBody
	public Seance get(@PathVariable Long id) {
		return seanceRepo.findOne(id);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/")
	@ResponseBody
	public String createseance(@RequestBody Seance seance) {
			seanceRepo.save(seance);
			return "success";
		

	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/")
	@ResponseBody
	public String editseance(@RequestBody Seance seance) {

		seanceRepo.save(seance);
		return "success";
	}

}
