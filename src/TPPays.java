
public class TPPays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ville paris = new Ville("paris");
		Ville marseille = new Ville("marseille");
		Ville lyon = new Ville("lyon");
		Ville evry = new Ville("evry");
		Capitale uneCapitale = new Capitale("paris");
		Pays unPays = new Pays("France" , uneCapitale , "Euro");
		unPays.ajouterVille(paris);
		unPays.ajouterVille(marseille);
		unPays.ajouterVille(lyon);
		unPays.ajouterVille(evry);
		
		System.out.println(Pays.getComteurPays());
		System.out.println(Pays.getComteurPays());
		System.out.println(uneCapitale.getNomMaj());
		System.out.println(unPays.toString());
		System.out.println(unPays.afficherVille());
		if(unPays.rechercheVille("lyon") == -1){
			System.out.println("la ville n'existe pas");
		}
		else{
			System.out.println("Indice de la ville à supprimer : "+unPays.rechercheVille("lyon"));
		}
			
		unPays.retirerVille("lyon");
		System.out.println(unPays.afficherVille());
		

	}

}
