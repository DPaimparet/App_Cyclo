package be.Denis.Model;

import java.util.Date;

public class Tresorier extends Personne {
	
	public Tresorier(String nom, String prenom, int matricule, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super(nom, prenom, matricule, login, password, dateNaissance, adresse, email, sex, inscription, fonction);
	}
}
