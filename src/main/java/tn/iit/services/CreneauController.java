package tn.iit.services;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.dao.CreneauRepositorie;
import tn.iit.dao.EnsignantRepositorie;
import tn.iit.dao.GroupeRepositorie;
import tn.iit.dao.SalleRepositorie;
import tn.iit.dao.SeanceRepositorie;
import tn.iit.entitie.Creneau;
import tn.iit.entitie.Enseignant;
import tn.iit.entitie.Groupe;
import tn.iit.entitie.Nombre;
import tn.iit.entitie.Salle;
import tn.iit.entitie.Seance;
import tn.iit.utils.SendMail;

@Controller
@RequestMapping("api/creneau")
@CrossOrigin(origins = "*")
public class CreneauController {
	@Autowired
	private CreneauRepositorie creneauRepositorie;
	@Autowired
	private EnsignantRepositorie ensignantRepositorie;
	@Autowired
	private SalleRepositorie salleRepositorie;
	@Autowired
	private GroupeRepositorie groupeRepositorie;
	@Autowired
	private SeanceRepositorie seanceRepositorie;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	@ResponseBody
	public List<Creneau> liste() {
		return creneauRepositorie.findAll();

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		creneauRepositorie.delete(id);
		return "success";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	@ResponseBody
	public Creneau get(@PathVariable Long id) {
		return creneauRepositorie.findOne(id);
	}

	
	@GetMapping("/compteur/")
	@ResponseBody
	public Nombre get() {
		return new Nombre(creneauRepositorie.count(), ensignantRepositorie.count(), groupeRepositorie.count(),
				seanceRepositorie.count(), salleRepositorie.count());
	}


	@PostMapping(value = "/")
	@ResponseBody
	public String createCreneau(@RequestParam("idGroupe") String idGroupe,
			@RequestParam("idEnseignant") String idEnseignant, @RequestParam("idSalle") String idSalle,
			@RequestParam("idSeance") String idSeance) {

		Enseignant enseignant = ensignantRepositorie.getOne(Long.valueOf(idEnseignant));
		Groupe groupe = groupeRepositorie.getOne(Long.valueOf(idGroupe));
		Salle salle = salleRepositorie.getOne(Long.valueOf(idSalle));
		Seance seance = seanceRepositorie.getOne(Long.valueOf(idSeance));

		Creneau newCreneau = new Creneau(groupe, enseignant, seance, salle, new Date().toString());
		newCreneau.setEtat(true);
		creneauRepositorie.save(newCreneau);
		SendMail s = new SendMail(enseignant.getMail(), "Vous ete affecter à la Seance " + seance.getLibelleSeance() + " prevu le "
				+ seance.getDate().toString() + " du Groupe " + groupe.getLibelle());

		return "success";
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/creneauSeance/")
	@ResponseBody
	public List<Creneau> getCreneauBySeance(@RequestParam Long idSeance1, @RequestParam Date date,
			@PathVariable Long idSeance) {
		Seance seance = seanceRepositorie.findOne(idSeance);
		return creneauRepositorie.getCreneauBySeance(seance, date);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	@ResponseBody
	public String editLanguage(@RequestBody Creneau creneau) {
		creneauRepositorie.save(creneau);
		return "success";
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/annuller/{id}")
	@ResponseBody
	public String annullerCreneau(@PathVariable Long id) {
		creneauRepositorie.annuler(id);
		Enseignant e = creneauRepositorie.getOne(id).getEnseignant();
		SendMail s = new SendMail(e.getMail(),
				"la Seance " + creneauRepositorie.getOne(id).getSeance().getLibelleSeance() + " prevu le "
						+ creneauRepositorie.getOne(id).getSeance().getDate().toString() + " du Groupe "
						+ creneauRepositorie.getOne(id).getGroupe().getLibelle() + " est annuler");
		return "success";
	}

}
