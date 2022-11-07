package yuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparator.ComparatorCategorie;

public class Categorie_service {
	
	public void getTopCategProduit(Stockk stock, String choix) {
		List<Produit> oProduit = stock.getProduit();
		List<Produit> oProduitCateg = new ArrayList<Produit>();
		String nomCateg="";
		boolean trouver=false;
		choix=choix.substring(0, 1).toUpperCase() + choix.substring(1);
		
		for (int i = 0; i < oProduit.size(); i++) {
			nomCateg= oProduit.get(i).getCategorie().getNom();

			if (nomCateg.trim().equals(choix)) {
				oProduitCateg.add(oProduit.get(i));
				trouver=true;
			}	
		}
		if (!trouver) {
			System.out.println("La categorie n'est pas trouvée");
		}else {
			Collections.sort(oProduitCateg, new ComparatorCategorie());
			for (int j = 0; j <10 && j<oProduitCateg.size() ; j++) {
				System.out.println(j + 1 + "." + oProduitCateg.get(j).getNom()+", score : " +oProduitCateg.get(j).getNutritions().getScore().toUpperCase()+", categorie : "+oProduitCateg.get(j).getCategorie().getNom());
			}
		}
	}
}
