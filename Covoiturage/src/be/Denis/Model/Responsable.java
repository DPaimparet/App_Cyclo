package be.Denis.Model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;

public class Responsable extends Personne {
	private Balade balade;
	private Categorie cat;
	private List<Balade> listeBalade;
	
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAO<Responsable> ResponsableDAO = adf.getResponsableDAO();
	private DAO<Categorie> CategorieDAO = adf.getCategorieDAO();
	private DAO<Balade> BaladeDAO = adf.getBaladeDAO();
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

	/**
	 * @return the listeBalade
	 */
	public List<Balade> getListeBalade() {
		return listeBalade;
	}

	/**
	 * @param listeBalade the listeBalade to set
	 */
	public void setListeBalade(List<Balade> listeBalade) {
		this.listeBalade = listeBalade;
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

	@SuppressWarnings("unchecked")
	public Responsable(String nom, String prenom, int matricule, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super(nom, prenom, matricule, login, password, dateNaissance, adresse, email, sex, inscription, fonction);
		try {
			cat = CategorieDAO.find(matricule);
			listeBalade = (List<Balade>) BaladeDAO.findAllBalade(cat.getNumCategorie());
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
	public void creerBalade(String lieu, Date dateBalade, String infoBalade, Double forfait) {
		balade = new Balade(lieu, dateBalade, infoBalade, forfait, cat.getNumCategorie());
		balade.sauvegarderBalade();
		listeBalade.add(balade);
	}
	
	
	public void ajouterCategorie(Categorie categorie) {
		cat = categorie;
		ResponsableDAO.addCategorie(this);
	}
	
	public void supprimerBalade(Balade baladeSupprimer) {
		listeBalade.remove(baladeSupprimer);
		baladeSupprimer.supprimerBalade();
	}
	
	
	

}
