package yuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import comparator.ComparatorAllergene;
import comparator.ComparatorMarqueCateg;


public class Produit_service  {
	public void getTopCategMarqueProduit(Stockk stock, String categ, String marque) {
		List<Produit> oProduit = stock.getProduit();
		List<Produit> newProduit = new ArrayList<>();
		String nomCateg="";
		String nomMarque="";
		boolean trouver=false;
		marque=marque.substring(0, 1).toUpperCase() + marque.substring(1);
		categ=categ.substring(0, 1).toUpperCase() + categ.substring(1);
		
		for (int i = 0; i < oProduit.size(); i++) {
			nomCateg= oProduit.get(i).getCategorie().getNom();
			nomMarque = oProduit.get(i).getMarque().getNom();

			if (nomCateg.trim().equals(categ) && nomMarque.trim().equals(marque)) {
				newProduit.add(oProduit.get(i));
				trouver=true;
			}	
		}
		if (!trouver) {
			System.out.println("Le Produit n'est pas trouvée");
		}else {
			Collections.sort(newProduit, new ComparatorMarqueCateg());
			
			for (int j = 0; j <10 && j<newProduit.size() ; j++) {
				System.out.println(j + 1 + "." + newProduit.get(j).getNom()+", score : " +newProduit.get(j).getNutritions().getScore().toUpperCase()+", marque : "+newProduit.get(j).getMarque().getNom()+", categorie : "+newProduit.get(j).getCategorie().getNom());
			}
		}
	}
	
	
	public void listAllergene(Stockk stock) {

		List<Produit> oProduit = stock.getProduit();
		List<Allergene> oAllergene=new ArrayList<Allergene>();

		HashMap<String, Allergene> map = new HashMap<String, Allergene>();

		String nomAllergene = "";
		int total = 0;
		
		for (Produit element : oProduit) {
			
			for (int i = 0; i < element.getAllergene().size(); i++) {
				nomAllergene = element.getAllergene().get(i).getNom();
				
//				System.out.println(nomAllergene);
				if(!nomAllergene.equals("Aucun allergene")) {
					if (map.get(nomAllergene) == null) {
						map.put(nomAllergene, new Allergene(nomAllergene,0));
					}
					total=map.get(nomAllergene).getNbProduitApparait();
					total=total+1;
					map.put(nomAllergene,new Allergene(nomAllergene,total));
				}
				
			}
		}
		oAllergene.addAll(map.values());
		Collections.sort(oAllergene, new ComparatorAllergene());
		for (int j = 0;  j <10 && j < oAllergene.size(); j++) {
			System.out.println(j+1+"."+oAllergene.get(j).getNom());
			
		}
//		for (Produit element : oProduit) {
//			
//			nomAllergene = element.getAllergene().get(total);
//
////			System.out.println(nomRegion);
//			if (map.get(nomRegion) == null) {
//				map.put(nomRegion, new Region(nomRegion));
//			}
//			population=element.getPopulation();
//			
//			population=population+map.get(nomRegion).getPopulation();
//			
//			Region region=map.get(nomRegion);
//			region.setPopulation(population);
//			
//		}
//		
//		
//		oRegion.addAll(map.values());
//
////		System.out.println(map.entrySet());
//		Collections.sort(oRegion, new ComparatorDixRegionMax());
//		for(int i=0;i<10;i++) {
//			System.out.println(i+1+"."+oRegion.get(i).getNom());
//		}



	}
}
