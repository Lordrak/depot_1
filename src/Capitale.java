
public class Capitale {
	private String nom;
	private int superficie;
	private int nbHab;
	
	public Capitale(){
		
	}
	
	public Capitale(String unNom){
		this.nom = unNom;

	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String unNom){
		this.nom = unNom;
	}
	
	public int getSuperficie(){
		return superficie;
	}
	
	public void setSuperficie(int uneSuperficie){
		this.superficie = uneSuperficie;
	}
	
	public int getNbHab(){
		return nbHab;
	}

	public void setNbHab(int unNbHab){
		this.nbHab = unNbHab;
	}
	
	public String getNomMaj(){

		return nom.toUpperCase().charAt(0) + nom.substring(1);
	}
}
