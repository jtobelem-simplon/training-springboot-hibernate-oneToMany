package hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
	
	List<Etudiant> findByNom(String nom);
	
	List<Etudiant> findByNomContainingIgnoreCase(String nom);
	
	List<Etudiant> findTop3ByOrderByNomAsc();
	
	List<Etudiant> findAllByOrderByNomDesc();
	
}
