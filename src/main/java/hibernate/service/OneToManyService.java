package hibernate.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.Application;
import hibernate.model.Etudiant;
import hibernate.model.Groupe;
import hibernate.repository.EtudiantRepository;
import hibernate.repository.GroupeRepository;

@Service
public class OneToManyService {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	GroupeRepository groupeRepository;

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@PersistenceContext
	private EntityManager em;

	public void create() {
		log.info(">> CREATE etudiants and groupe");

		List<Etudiant> etudiants = Arrays.asList(new Etudiant("BENCHERIF Djamel"), new Etudiant("DABIN Megan"),
				new Etudiant("DESOBEAU TEDDY"), new Etudiant("LENOIR ROMAIN"), new Etudiant("LORIENT Erwan"),
				new Etudiant("MACEDO CODY"));

		Groupe csid = new Groupe("csid");

		for (Etudiant etudiant : etudiants) {
			csid.addEtudiant(etudiant);
		}

		groupeRepository.save(csid);
	}

	public void read() {
		log.info(">> READ les etudiants");
		List<Etudiant> etudiantList = etudiantRepository.findAll();

		for (Etudiant etudiant : etudiantList) {
			log.info(etudiant.getNom());
		}

		log.info(">> READ les groupes");
		List<Groupe> groupList = groupeRepository.findAll();

		for (Groupe groupe : groupList) {
			log.info("[groupe : {}]", groupe.getLibelle());
			List<Etudiant> etudiantListGroupe = groupe.getEtudiants();

			for (Etudiant etudiant : etudiantListGroupe) {
				log.info(etudiant.getNom());
			}
		}
	}

	public void update() {
		log.info(">> UPDATE les etudiants");
		List<Etudiant> etudiantList = etudiantRepository.findAll();

		for (Etudiant etudiant : etudiantList) {
			String[] nom = etudiant.getNom().split(" ");

			etudiant.setNom(nom[0].toUpperCase() + " " + nom[1].toLowerCase());
			etudiantRepository.save(etudiant);
		}
	}

	public void delete() {
		log.info(">> DELETE les etudiants");
		etudiantRepository.deleteAllInBatch();
		log.info(">> DELETE les groupes");
		groupeRepository.deleteAllInBatch();
	}

	public void hqlQuery(String etudiantNom) {
		log.info(">> HQL query");
		
		String hql = "FROM Etudiant E WHERE E.nom like :nom"; // the java class, not entity
		TypedQuery<Etudiant> query = em.createQuery(hql, Etudiant.class);
		query.setParameter("nom", "%ega%");
		List<Etudiant> results = query.getResultList();

		for (Etudiant etudiant : results) {
			log.info(etudiant.getNom());
		}
	}

}
