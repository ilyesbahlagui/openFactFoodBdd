package yuka;

import java.io.IOException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stockk stock = new Stockk();
//		System.out.println(stock.getProduit());

		Scanner scanner = new Scanner(System.in);

		// BOOLEAN
		boolean console = true;

		// Choix de l'utilisateur

		while (console) {

			System.out.println("Faites un choix\n");
			System.out.println("1. rechercher les meilleurs produits pour une Marque donnée\n");
			System.out.println("2.rechercher les meilleurs produits pour une Categorie donnée\n");
			System.out.println("3.Donner une categorie et une marque pour afficher ses meilleurs produits\n");
			System.out.println("4.Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent\n");

			System.out.println("9. Sortir");
			String choix = scanner.nextLine();

			switch (choix) {
			case "1": {
				System.out.println("Donner une marque pour afficher ses meilleurs produits");
				choix = scanner.nextLine();
				Marque_service topMarque = new Marque_service();
				topMarque.getTopMarqueProduit(stock, choix);
				break;
			}
			case "2": {
				System.out.println("Donner une categorie pour afficher ses meilleurs produits");
				choix = scanner.nextLine();
				Categorie_service topCateg = new Categorie_service();
				topCateg.getTopCategProduit(stock, choix);
				break;
			}
			case "3": {
				System.out.println("Donner une categorie et une marque pour afficher ses meilleurs produits");
				System.out.println("La Marque ?");
				String marque = scanner.nextLine();
				System.out.println("Categorie ?");
				String categ=scanner.nextLine();
				Produit_service topCateg = new Produit_service();
				topCateg.getTopCategMarqueProduit(stock, categ, marque);
				break;
			}
			case "4": {

				Produit_service lisAllergene = new Produit_service();
				lisAllergene.listAllergene(stock);
				break;
			}
			
			case "9": {
				console=false;
			}
			
			}
		}

//		System.out.println(stock);

	}

}
