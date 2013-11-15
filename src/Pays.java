import java.util.ArrayList;


public class Pays {
	private String nom;
	private int superficie;
	private int nbHab;
	private String monnaie;
	private Capitale saCapitale;
	private static int compteurPays = 0;
	private Ville[] lesVilles;
	private int nbVille = 0;
	
	public Pays(){
		compteurPays +=2;
		lesVilles = new Ville[10];
	}
	
	public Pays(String unNom, Capitale uneCapitale, String uneMonnaie){
		this.nom = unNom;
		this.saCapitale = uneCapitale;
		this.monnaie = uneMonnaie;
		compteurPays += 2;
		lesVilles = new Ville[10];
	}
	public void setNom(String unNom){
		this.nom = unNom;
	}
	
	public static int getComteurPays(){
		return compteurPays ;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void setSuperficie(int uneSuperficie){
		this.superficie = uneSuperficie;
	}
	
	public int getSuperficie(){
		return this.superficie;
	}
	
	public void setNbHab(int unNbHab){
		this.nbHab = unNbHab;
	}
	
	public int getNbHab(){
		return this.nbHab;
	}
	
	public void setCapitale(Capitale uneCapitale){
		this.saCapitale = uneCapitale;
	}
	
	public void setMonnaie(String uneMonnaie){
		this.monnaie = uneMonnaie;
	}
	
	public String getMonnaie(){
		return this.monnaie;
	}
	
	public void ajouterVille(Ville uneVille){
		if(nbVille < lesVilles.length) {
			this.lesVilles[nbVille] = uneVille;
			this.nbVille ++;
		}
		else{
			System.out.println("Trop de ville");
		}
	}
	
	public int rechercheVille(String unNomVille){
		int i = 0;
		while(i < nbVille && unNomVille != this.lesVilles[i].getNom() ){
			i++;
		}
		if(i == nbVille){
			i = -1;
		}
		return i;
		
	}
	
	public void retirerVille(String unNomVille){
		int position = rechercheVille(unNomVille);
		
		if(position != -1){
			while(position < nbVille - 1){
				lesVilles[position] = lesVilles[position + 1];
				position++;
			}
			nbVille --;
		}
		else
		{
			System.out.println("La ville n'existe pas");
		}
	}
	
	public String toString(){
		return "Nom: " + this.nom + ", Capitale : "+ this.saCapitale.getNom() + ", Monnaie : " + this.monnaie ;
	}
	
	public String afficherVille(){
		int i = 0;
		String nomVilles = "Les villes sont [";
		while(i < this.nbVille){
			nomVilles += this.lesVilles[i].getNom( )+ " ";
			i++;
		}
		nomVilles += "]";
		return nomVilles;
	}
	
	

	

}
