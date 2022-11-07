package yuka;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetListGlobal {

	public GetListGlobal() {
		// TODO Auto-generated constructor stub
		
	}
	
	//********************GET lIST INGREDIENT***********************//
	public static Set<Ingredient> getListIngredient(String listIngredient) {
		listIngredient = listIngredient.replaceAll("\\,", ";").replaceAll("\\.", " ").replaceAll("\\(.*\\)", "").replaceAll("\\_", " ").replaceAll("\\:", ";").replaceAll("\\*", "").trim();
		Set<Ingredient> newIngredient = new HashSet<Ingredient>();
//		System.out.println("Ingredient => "+listIngredient);
		
		if (listIngredient==null) {
			Ingredient ingredient=new Ingredient();
			ingredient.setNom("Aucun ingredient");
			newIngredient.add(ingredient);
			return newIngredient;
		}
		else {
			String[] tabIngredient = listIngredient.split(";");
			for (String string : tabIngredient) {
				Ingredient ingredient=new Ingredient();
				ingredient.setNom(string.trim());
				newIngredient.add(ingredient);

			}
			
			return newIngredient;
		}
		
	}
	
	//********************GET lIST Allergene***********************//
	public static  Set<Allergene> getListAllergene(String listAllergene) {
		
		listAllergene = listAllergene.replaceAll("\\,", ";").replaceAll("\\.", " ").replaceAll("\\(.*\\)", "").replaceAll("\\_", " ").replaceAll("\\:", ";").replaceAll("\\-", ";").replaceAll("\\*", "").trim();
		Set<Allergene> newAllergene = new HashSet<Allergene>();
		

		if (listAllergene=="") {
			Allergene allergene=new Allergene(); 
			allergene.setNom("Aucun allergene");
			newAllergene.add(allergene);
			return newAllergene;
		}
		else {
			String[] tabAdditif = listAllergene.split(";");
			for (String string : tabAdditif) {
				Allergene allergene=new Allergene(); 
				allergene.setNom(string.trim());

				newAllergene.add(allergene);

			}
			
			return newAllergene;
		}
		
	}
	
	//********************GET lIST ADDITIF***********************//
	public static Set<Additif> getListAdditif(String listAdditif) {
		
		listAdditif = listAdditif.replaceAll("\\,", ";").replaceAll("\\.", " ").replaceAll("\\(.*\\)", "").replaceAll("\\_", " ").replaceAll("\\:", ";").replaceAll("\\-", ";").replaceAll("\\*", "").trim();
		Set<Additif> newAdditif = new HashSet<Additif>();
		
//		System.out.println("Additif => "+listAdditif);
		if (listAdditif=="") {
			Additif additif=new Additif();
			additif.setNom("Aucun additif");
 			newAdditif.add(additif);
			return newAdditif;
		}
		else {
			String[] tabAdditif = listAdditif.split(";");
			for (String string : tabAdditif) {
				Additif additif=new Additif();
				additif.setNom(string.trim());
				newAdditif.add(additif);

			}
			
			return newAdditif;
		}
		
	}
	

}
