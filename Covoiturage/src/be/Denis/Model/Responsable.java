package be.Denis.Model;

import java.util.Date;

public class Responsable extends Personne {
	Balade balade;
	
	/***
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param matricule
	 * @param login
	 * @param password
	 * @param dateNaissance
	 * @param adresse
	 * @param email
	 * @param inscription
	 */
	public Responsable(String nom, String prenom, int matricule, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super(nom, prenom, matricule, login, password, dateNaissance, adresse, email, sex, inscription, fonction);
	}
	
	/***
	 * Méthode d'appel pour créer une balade
	 * @param lieu
	 * @param dateBalade
	 * @param infoBalade
	 * @param forfait
	 */
	public void creerBalade(String lieu, Date dateBalade, String infoBalade, double forfait) {
		balade = new Balade(lieu, dateBalade, infoBalade, forfait);
		balade.sauvegarderBalade();
	}

	

}
