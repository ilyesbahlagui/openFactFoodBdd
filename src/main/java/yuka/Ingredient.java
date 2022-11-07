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
@Table(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;

	
	@ManyToMany
	@JoinTable(name = "ingredient_produit", joinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"))
	private Set<Produit> produit = new HashSet<Produit>();
	
	public Ingredient() {

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


}
