package hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
