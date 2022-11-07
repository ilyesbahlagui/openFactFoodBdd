package yuka;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marque")
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	
	@OneToMany(mappedBy="marque")
	private Set<Produit> produit = new HashSet<Produit>();
	
	public Marque() {

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
