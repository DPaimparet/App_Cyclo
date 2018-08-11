package be.Denis.Model;

import java.sql.SQLException;
import java.util.Date;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;
import be.Denis.Vue.DashBoard;

public class Personne {
	private String nom;
	private String prenom;
	private int matricule;
	private String login;
	private String password;
	private Date dateNaissance;
	private String adresse;
	private String email;
	private String sex;
	private Date inscription;
	private String fonction;
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAO<Personne> PersonneDAO = adf.getPersonneDAO();
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the matricule
	 */
	public int getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the inscription
	 */
	public Date getInscription() {
		return inscription;
	}

	/**
	 * @param inscription the inscription to set
	 */
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * @param fonction the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
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
	 * @param sex
	 * @param inscription
	 * @param fonction
	 */
	public Personne(String nom, String prenom, int matricule, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.login = login;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.email = email;
		this.sex = sex;
		this.inscription = inscription;
		this.fonction = fonction;
	}
	
	public Personne(String nom, String prenom, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.email = email;
		this.sex = sex;
		this.inscription = inscription;
		this.fonction = fonction;
	}

	public Personne(String login, String password) {
		this.login = login;
		this.password = password;
	}

	
	/***
	 * Méthode de connexion qui permet de retourner l'utilisateur vers sa vue si il est présent dans la base de données
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Boolean connexion() throws ClassNotFoundException, SQLException {
		Personne p = PersonneDAO.find(login, password);
		if(p!=null)
		{
			DashBoard.init(p);
			return true;
		}
		else return false;
	}
	
	/***
	 * Méthode qui permet d'inscrire une personne dans la base de donnée
	 */
	public void inscription() {
		PersonneDAO.create(this);
	}
	
	/***
	 * Méthode qui permet de vérifier si un compte existe déjà avec ce login
	 */
	public boolean exist(String login, String mail) {
		boolean e = PersonneDAO.compteExist(login, email);
		return e;
	}
	
	/***
	 * Méthode update
	 */
	protected void updateInfo() {
		PersonneDAO.update(this);
	}
}
