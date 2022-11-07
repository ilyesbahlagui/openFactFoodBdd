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
@Table(name = "score")
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "note", length = 50, nullable = false)
	private String note;
	
	@OneToMany(mappedBy="score")
	private Set<Produit> produit = new HashSet<Produit>();
	
	

	public Score() {

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

	public String getScore() {
		return note;
	}

	public void setScore(String note) {
		this.note = note;
	}

}
