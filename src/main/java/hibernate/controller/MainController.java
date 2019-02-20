package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hibernate.model.Etudiant;
import hibernate.repository.EtudiantRepository;
import hibernate.service.MainService;


@RestController
public class MainController {
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/etudiants")
	public List<Etudiant> getAllPeople(){
		return etudiantRepository.findAll();
	}
	
	@GetMapping("/init")
	public void create() {
		mainService.delete();
		mainService.create();
	}

}
