package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import hibernate.model.Etudiant;
import hibernate.repository.EtudiantRepository;
import hibernate.service.OneToManyService;


@RestController
public class OneToManyController {
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	OneToManyService crudService;
	
	@GetMapping("/etudiants")
	public List<Etudiant> getAllPeople(){
		return etudiantRepository.findAll();
	}
	
	@GetMapping("/init")
	public void create() {
		crudService.create();
	}

}
