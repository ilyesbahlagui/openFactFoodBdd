package yuka;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Stockk {
	private List<Produit> produit = new ArrayList<Produit>();

	public Stockk() throws IOException {
		this.getListProduit();

	}

	public void getListProduit() throws IOException {
		Path pathFile = Paths.get("C:\\work-space-java-2\\traitement-fichier\\src\\yuka\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);
		
		for (int i = 1; i < lines.size(); i++) {
			String[] lineProduit = lines.get(i).split("\\|",-1);
//			System.out.println(lines.get(i));

			//Instance des objets
			Categorie categorie = new Categorie(lineProduit[0]);
			Marque marque = new Marque(lineProduit[1]);
			
			
			//valeur sans instances
			String nomProduit = lineProduit[2];
			String scoreNutri=lineProduit[3];
			ScoreNutri scoreNutr=new ScoreNutri(lineProduit[3]);
//			double energie=Double.valueOf(lineProduit[5]);
//			System.out.println("indice ou je tombre "+i);

			double energie=lineProduit[5]==""?0:Double.valueOf(lineProduit[5]);
			 double graisse=lineProduit[6]==""?0:Double.valueOf(lineProduit[6]);
			 double sucres=lineProduit[7]==""?0:Double.valueOf(lineProduit[7]);
			 double fibres=lineProduit[8]==""?0:Double.valueOf(lineProduit[8]);
			 double proteines=lineProduit[9]==""?0:Double.valueOf(lineProduit[9]);
			 double sel=lineProduit[10]==""?0:Double.valueOf(lineProduit[10]);
			
			 
			 //Liste d'objet d'instance
//			System.out.println(getListIngredient(lineProduit[4]));
//			System.out.println(getListAdditif(lineProduit[29]));
//			System.out.println(getListAllergene(lineProduit[28]));
//			
			this.produit.add(new Produit(nomProduit, categorie, marque, getListIngredient(lineProduit[4]), getListAllergene(lineProduit[28]), getListAdditif(lineProduit[29]), scoreNutr, energie, graisse, sucres, fibres, proteines, sel));

		}
		

	}
	
	
	//********************GET lIST INGREDIENT***********************//
	public List<Ingredient> getListIngredient(String listIngredient) {
		listIngredient = listIngredient.replaceAll("\\,", ";").replaceAll("\\.", " ").replaceAll("\\(.*\\)", "").replaceAll("\\_", " ").replaceAll("\\:", ";").replaceAll("\\*", "").trim();
		List<Ingredient> newIngredient = new ArrayList<Ingredient>();
//		System.out.println("Ingredient => "+listIngredient);
		
		if (listIngredient==null) {
			newIngredient.add(new Ingredient("Aucun ingredient"));
			return newIngredient;
		}
		else {
			String[] ingredient = listIngredient.split(";");
			for (String string : ingredient) {
				newIngredient.add(new Ingredient(string.trim()));

			}
			
			return newIngredient;
		}
		
	}
	
	//********************GET lIST Allergene***********************//
	public List<Allergene> getListAllergene(String listAllergene) {
		
		listAllergene = listAllergene.replaceAll("\\,", ";").replaceAll("\\.", " ").replaceAll("\\(.*\\)", "").replaceAll("\\_", " ").replaceAll("\\:", ";").replaceAll("\\-", ";").replaceAll("\\*", "").trim();
		List<Allergene> newAllergene = new ArrayList<Allergene>();
		

		if (listAllergene=="") {
			newAllergene.add(new Allergene("Aucun allergene"));
			return newAllergene;
		}
		else {
			String[] additif = listAllergene.split(";");
			for (String string : additif) {
				newAllergene.add(new Allergene(string.trim()));

			}
			
			return newAllergene;
		}
		
	}
	
	//********************GET lIST ADDITIF***********************//
	public List<Additif> getListAdditif(String listAdditif) {
		
		listAdditif = listAdditif.replaceAll("\\,", ";").replaceAll("\\.", " ").replaceAll("\\(.*\\)", "").replaceAll("\\_", " ").replaceAll("\\:", ";").replaceAll("\\-", ";").replaceAll("\\*", "").trim();
		List<Additif> newAdditif = new ArrayList<Additif>();
		
//		System.out.println("Additif => "+listAdditif);
		if (listAdditif=="") {
			newAdditif.add(new Additif("Aucun additif"));
			return newAdditif;
		}
		else {
			String[] additif = listAdditif.split(";");
			for (String string : additif) {
				newAdditif.add(new Additif(string.trim()));

			}
			
			return newAdditif;
		}
		
	}
	
	

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
}
