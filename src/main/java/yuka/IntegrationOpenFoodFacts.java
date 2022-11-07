package yuka;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {
		List<Produit> produit= new ArrayList<Produit>();
		Path pathFile = Paths.get("C:\\work-space-java-2\\traitement-fichier\\src\\yuka\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);

		for (int i = 1; i < lines.size(); i++) {
			String[] lineProduit = lines.get(i).split("\\|", -1);
//			System.out.println(lines.get(i));

			// Instance des objets
			Categorie categorie = new Categorie();
			categorie.setNom(lineProduit[0]);
			Marque marque = new Marque();
			marque.setNom(lineProduit[1]);

			// valeur sans instances
			String nomProduit = lineProduit[2];
			Score score = new Score();
			score.setScore(lineProduit[3]);

			double energie = lineProduit[5] == "" ? 0 : Double.valueOf(lineProduit[5]);
			double graisse = lineProduit[6] == "" ? 0 : Double.valueOf(lineProduit[6]);
			double sucres = lineProduit[7] == "" ? 0 : Double.valueOf(lineProduit[7]);

			// Liste d'objet d'instance
//			System.out.println(getListIngredient(lineProduit[4]));
//			System.out.println(getListAdditif(lineProduit[29]));
//			System.out.println(getListAllergene(lineProduit[28]));
			Produit newProduit = new Produit();
			 newProduit.getAdditif().addAll(GetListGlobal.getListAdditif(lineProduit[29]));
			 newProduit.getAllergene().addAll(GetListGlobal.getListAllergene(lineProduit[28]));
			 newProduit.getIngredient().addAll(GetListGlobal.getListIngredient(lineProduit[4]));
			 newProduit.setNom(nomProduit);
			 newProduit.setCategorie(categorie);
			 newProduit.setMarque(marque);
			 newProduit.setScore(score);
			 newProduit.setSucres(sucres);
			 newProduit.setGraisse(graisse);
			 newProduit.setEnergie(energie);
			produit.add(newProduit);

		

		}
//		System.out.println(produit);
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("openFoodFacts");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		

		
		for (int i = 0; i < produit.size(); i++) {
			
			//********************MARQUE*********************//
			TypedQuery<Marque> query = em.createQuery("SELECT distinct m FROM Marque m where m.nom=:param1 ", Marque.class);
			query.setParameter("param1", produit.get(i).getMarque().getNom());
			List<Marque> marques = query.getResultList();
			transaction.begin();
			if (marques.size()==0) {
				em.persist(produit.get(i).getMarque());		
			}else {	
				produit.get(i).setMarque(marques.get(0));		
			}
			
			//***************CATEGORIE********************//
			TypedQuery<Categorie> queryCateg = em.createQuery("SELECT distinct c FROM Categorie c where c.nom=:param2 ", Categorie.class);
			queryCateg.setParameter("param2", produit.get(i).getCategorie().getNom());
			List<Categorie> categories = queryCateg.getResultList();
			if (categories.size()==0) {
				em.persist(produit.get(i).getCategorie());
			}else {
				produit.get(i).setCategorie(categories.get(0));
			
			}
			
			//***************SCORE********************//
			TypedQuery<Score> queryScore = em.createQuery("SELECT distinct s FROM Score s where s.note=:param2 ", Score.class);
			queryScore.setParameter("param2", produit.get(i).getScore().getScore());
			List<Score> scores = queryScore.getResultList();
			if (scores.size()==0) {
				em.persist(produit.get(i).getScore());
			}else {
				produit.get(i).setScore(scores.get(0));
			
			}
		
			//*****************INGREDIENT*****************//
			Set<Ingredient> newIngredientBdd=new  HashSet<Ingredient>();
			for (Ingredient ingr :produit.get(i).getIngredient() ) {
				System.out.println("Ingredient => "+ingr.getNom());
				TypedQuery<Ingredient> queryIngredient = em.createQuery("SELECT distinct ing FROM Ingredient ing where ing.nom=:param3", Ingredient.class);
				queryIngredient.setParameter("param3", ingr.getNom());
				List<Ingredient> ingredients = queryIngredient.getResultList();
				
				
				if (ingredients.size()==0) {
					em.persist(ingr);
				}else {

					newIngredientBdd.add(ingredients.get(0));
				
				}
				
			}
			produit.get(i).setIngredient(newIngredientBdd);
			
			
			//*****************Additif*****************//
			Set<Additif> newAdditifBdd=new  HashSet<Additif>();
			for (Additif element :produit.get(i).getAdditif() ) {
				System.out.println("Additif => "+element.getNom());
				TypedQuery<Additif> queryAdditif = em.createQuery("SELECT distinct add FROM Additif add where add.nom=:param4", Additif.class);
				queryAdditif.setParameter("param4", element.getNom());
				List<Additif> additifs = queryAdditif.getResultList();
				
				
				if (additifs.size()==0) {
					em.persist(element);
				}else {

					newAdditifBdd.add(additifs.get(0));
				
				}
				
			}
			produit.get(i).setAdditif(newAdditifBdd);
			
			
			//*****************Allergene*****************//
			Set<Allergene> newAllergeneBdd=new  HashSet<Allergene>();
			for (Allergene element :produit.get(i).getAllergene() ) {
				System.out.println("Allergene => "+element.getNom());
				TypedQuery<Allergene> queryAllergene = em.createQuery("SELECT distinct alg FROM Allergene alg where alg.nom=:param5", Allergene.class);
				queryAllergene.setParameter("param5", element.getNom());
				List<Allergene> allergenes = queryAllergene.getResultList();
				
				
				if (allergenes.size()==0) {
					em.persist(element);
				}else {

					newAllergeneBdd.add(allergenes.get(0));
				
				}
				
			}
			produit.get(i).setAllergene(newAllergeneBdd);
			em.persist(produit.get(i));
			transaction.commit();
			
		}
		
	}
}
