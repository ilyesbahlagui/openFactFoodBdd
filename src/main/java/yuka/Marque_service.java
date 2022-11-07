package yuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparator.ComparatorMarque;



public class Marque_service {
	
	public void getTopMarqueProduit(Stockk stock, String choix) {
		List<Produit> oProduit = stock.getProduit();
		List<Produit> oProduitMarque = new ArrayList<>();
		String nomMarque="";
		boolean trouver=false;
		choix=choix.substring(0, 1).toUpperCase() + choix.substring(1);
		
		for (int i = 0; i < oProduit.size(); i++) {
			nomMarque = oProduit.get(i).getMarque().getNom();
//			System.out.println(nomMarque);
			if (nomMarque.equals(choix)) {
				oProduitMarque.add(oProduit.get(i));
				trouver=true;
			}	
		}
		if (!trouver) {
			System.out.println("La marque n'est pas trouvée");
		}else {
			Collections.sort(oProduitMarque, new ComparatorMarque());
			for (int j = 0; j <10 && j<oProduitMarque.size() ; j++) {
				System.out.println(j + 1 + "." + oProduitMarque.get(j).getNom()+", score : " +oProduitMarque.get(j).getNutritions().getScore().toUpperCase());
			}
		}
	}
}
