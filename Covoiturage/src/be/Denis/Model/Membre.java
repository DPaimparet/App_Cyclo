package be.Denis.Model;

import java.util.Date;
import java.util.List;

public class Membre extends Personne {

	private float soldeCompte;
	private List<Vehicule> listeVehicule;
	private List<Categorie> listeCategorie;

	
	/**
	 * @return the soldeCompte
	 */
	public float getSoldeCompte() {
		return soldeCompte;
	}

	/**
	 * @param soldeCompte the soldeCompte to set
	 */
	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public Membre(String nom, String prenom, int matricule, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super(nom, prenom, matricule, login, password, dateNaissance, adresse, email, sex, inscription, fonction);
		this.soldeCompte = connaitreSolde();
	}
	
	public void updateInfo() {
		// TODO mise à jours vers la DB
	}
	
	public void payerCotisation(int cotisation) {
		soldeCompte += cotisation;
		// TODO update DB
	}
	
	public void payerForfaitBalade(float forfait) {
		soldeCompte += forfait;
		// TODO update DB
	}
	
	public void reserverBalade(int nbrP, int nbrV) {
		
	}
	
	public void proposerPlace(int nbrP, int nbrV) {
		
	}
	
	public void ajouterVehicule(Vehicule vehicule) {
		listeVehicule.add(vehicule);
		// TODO mise à jour DB
	}
	
	public void retirerVehicule(Vehicule vehicule) {
		listeVehicule.remove(vehicule);
		// vehicule.getImmatriculation();
		// TODO mise à jour DB
	}
	
	private float connaitreSolde() {
		float solde = 0;
		return solde;
	}

}
