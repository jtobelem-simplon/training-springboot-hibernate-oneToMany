package hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.model.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {

}
