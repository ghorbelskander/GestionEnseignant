package tn.iit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.iit.repo.EnseignantRepo;


@Controller
@RequestMapping("Enseignant")
public class EnseignantController {
	@Autowired
	private EnseignantRepo enseignantRepo;
}
