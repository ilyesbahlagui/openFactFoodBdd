package yuka;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "allergene")
public class Allergene {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	@ManyToMany
	@JoinTable(name = "allergene_produit", joinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"))
	private Set<Produit> produit = new HashSet<Produit>();
	public Allergene() {

	}
	public Set<Produit> getProduit() {
		return produit;
	}

	public void setProduit(Set<Produit> produit) {
		this.produit = produit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
//	private int nbProduitApparait;


//	public Allergene(String nom,int nbProduitApparait) {
//		this.nom = nom;
//		this.nbProduitApparait = nbProduitApparait;
//	}
//	
//	
//	public int getNbProduitApparait() {
//		return nbProduitApparait;
//	}
//	public void setNbProduitApparait(int nbProduitApparait) {
//		this.nbProduitApparait = nbProduitApparait;
//	}



}
