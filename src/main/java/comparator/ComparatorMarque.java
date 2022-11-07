package comparator;

import java.util.Comparator;

import yuka.Produit;


public class ComparatorMarque  implements Comparator<Produit> {
	public int compare(Produit o1, Produit o2) {

		// pour les int on le fait manuellement avec des return et des if
		int result= o1.getNutritions().getScore().compareTo(o2.getNutritions().getScore());

		return result;
	}
}
