package yuka;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	
	
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="id_marque")
	private Marque marque;
	
	@ManyToOne
	@JoinColumn(name="id_score")
	private Score score;
	
	
	
	@ManyToMany
	@JoinTable(name = "ingredient_produit", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id"))
	private Set<Ingredient> ingredient = new HashSet<Ingredient>();
	
	@ManyToMany
	@JoinTable(name = "allergene_produit", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"))
	private Set<Allergene> allergene = new HashSet<Allergene>();
	
	@ManyToMany
	@JoinTable(name = "additif_produit", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "id"))
	private Set<Additif> additif = new HashSet<Additif>();
	
	
	
	@Column(name = "energie", length = 50, nullable = true)
	private double energie;
	@Column(name = "graisse", length = 50, nullable = true)
	private double graisse;
	@Column(name = "sucres", length = 50, nullable = true)
	private double sucres;


	public Produit() {

	}
	
	

	@Override
	public String toString() {
		return "Produit => " + nom + ", categorie=" + categorie + ", marque=" + marque + ", ingredient=" + ingredient + ", allergene="
				+ allergene + ", additif=" + additif + ", score=" + score +", energie="
				+ energie + ", graisse=" + graisse + ", sucres=" + sucres +"\n";
	}
	



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Set<Ingredient> getIngredient() {
		return ingredient;
	}

	public void setIngredient(Set<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

	public Set<Allergene> getAllergene() {
		return allergene;
	}

	public void setAllergene(Set<Allergene> allergene) {
		this.allergene = allergene;
	}

	public Set<Additif> getAdditif() {
		return additif;
	}

	public void setAdditif(Set<Additif> additif) {
		this.additif = additif;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public double getEnergie() {
		return energie;
	}

	public void setEnergie(double energie) {
		this.energie = energie;
	}

	public double getGraisse() {
		return graisse;
	}

	public void setGraisse(double graisse) {
		this.graisse = graisse;
	}

	public double getSucres() {
		return sucres;
	}

	public void setSucres(double sucres) {
		this.sucres = sucres;
	}



}
