package be.Denis.Model;

public class Categorie {
	private String nomCategorie;
	private int annee;
	private int numCategorie;
	
	/**
	 * @return the numCategorie
	 */
	public int getNumCategorie() {
		return numCategorie;
	}
	/***
	 * Constructeur
	 * @param nomCategorie
	 */
	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}
	
	protected void ajouterMembre() {
		
	}
}
