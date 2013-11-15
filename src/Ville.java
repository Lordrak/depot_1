
public class Ville {
	
	private String nom;
	private int superficie;
	private int nbHab;
	
	public Ville(){
		
	}

	public Ville(String unNom){
		
		this.nom = unNom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getNbHab() {
		return nbHab;
	}

	public void setNbHab(int nbHab) {
		this.nbHab = nbHab;
	}
	
	public String toString(){
		return nom;
	}
	
}
