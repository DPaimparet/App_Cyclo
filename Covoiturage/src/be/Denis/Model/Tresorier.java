package be.Denis.Model;

import java.util.Date;
import java.util.LinkedList;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;


public class Tresorier extends Personne {
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAO<Tresorier> TresorierDAO = adf.getTresorierDAO();
	
	public Tresorier(String nom, String prenom, int matricule, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super(nom, prenom, matricule, login, password, dateNaissance, adresse, email, sex, inscription, fonction);
	}
	
	public void updateInfo() {
		TresorierDAO.update(this);
	}
	
	public LinkedList<Transaction> getFraisDeplacement(){
		LinkedList<Transaction> liste = new LinkedList<Transaction>();
		liste = TresorierDAO.getListeDeplacement();
		return liste;
	}
}
