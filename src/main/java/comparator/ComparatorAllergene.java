package comparator;

import java.util.Comparator;

import yuka.Allergene;

public class ComparatorAllergene implements Comparator<Allergene> {

	public int compare(Allergene o1, Allergene o2) {


		if (o1.getNbProduitApparait() > o2.getNbProduitApparait()) {
			return -1;
		}
		if (o1.getNbProduitApparait() < o2.getNbProduitApparait()) {
			return 1;
		}

		return 0;

		
	}
}
