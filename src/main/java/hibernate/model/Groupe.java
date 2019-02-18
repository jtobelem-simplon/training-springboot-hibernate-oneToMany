package hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the groupes database table.
 * 
 */
@Entity
@Table(name="groupes")
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="groupe_id")
	private Integer groupeId;

	private String libelle;

	//bi-directional many-to-one association to Etudiant
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="groupe") //fetch=FetchType.EAGER, 
	private List<Etudiant> etudiants = new ArrayList<Etudiant>();

	public Groupe() {
	}

	public Groupe(String libelle) {
		this.libelle = libelle;
	}

	public Integer getGroupeId() {
		return this.groupeId;
	}

	public void setGroupeId(Integer groupeId) {
		this.groupeId = groupeId;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etudiant addEtudiant(Etudiant etudiant) {
		getEtudiants().add(etudiant);
		etudiant.setGroupe(this);

		return etudiant;
	}

	public Etudiant removeEtudiant(Etudiant etudiant) {
		getEtudiants().remove(etudiant);
		etudiant.setGroupe(null);

		return etudiant;
	}

}