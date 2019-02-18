package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the etudiants database table.
 * 
 */
@Entity
@Table(name="etudiants")
public class Etudiant  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="etudiant_pk")
	private Integer etudiantPk;

	private String nom;

	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="groupe_fk")
	private Groupe groupe;

	public Etudiant() {
	}
	
	public Etudiant(String nom) {
		super();
		this.nom = nom;
	}

	public Integer getEtudiantPk() {
		return this.etudiantPk;
	}

	public void setEtudiantPk(Integer etudiantPk) {
		this.etudiantPk = etudiantPk;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

}