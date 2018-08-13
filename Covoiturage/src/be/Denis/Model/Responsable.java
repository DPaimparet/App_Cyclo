package be.Denis.Model;

import java.sql.SQLException;
import java.util.Date;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;

public class Responsable extends Personne {
	private Balade balade;
	private Categorie cat;
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAO<Responsable> ResponsableDAO = adf.getResponsableDAO();
	private DAO<Categorie> CategorieDAO = adf.getCategorieDAO();
	/**
	 * @return the cat
	 */
	public Categorie getCat() {
		return cat;
	}

	/**
	 * @param cat the cat to set
	 */
	public void setCat(Categorie cat) {
		this.cat = cat;
	}

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
		try {
			cat = CategorieDAO.find(matricule);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateInfo() {
		ResponsableDAO.update(this);
	}
	
	/***
	 * Méthode d'appel pour créer une balade
	 * @param lieu
	 * @param dateBalade
	 * @param infoBalade
	 * @param forfait
	 */
	public void creerBalade(String lieu, Date dateBalade, String infoBalade, double forfait) {
		balade = new Balade(lieu, dateBalade, infoBalade, forfait, cat.getNumCategorie());
		balade.sauvegarderBalade();
	}
	
	
	public void ajouterCategorie(Categorie categorie) {
		cat = categorie;
		ResponsableDAO.addCategorie(this);
	}
	
	
	
	

}
