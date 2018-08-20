package be.Denis.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;

public class Membre extends Personne {

	private Double soldeCompte;
	private List<Vehicule> listeVehicule;
	private List<Categorie> listeCategorie;
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAO<Membre> MembreDAO = adf.getMembreDAO();
	private DAO<Categorie> CategorieDAO = adf.getCategorieDAO();
	private DAO<Balade> BaladeDAO = adf.getBaladeDAO();
	private DAO<Vehicule> VehiculeDAO = adf.getVehiculeDAO();

	/**
	 * @return the soldeCompte
	 */
	public Double getSoldeCompte() {
		return soldeCompte;
	}

	/**
	 * @param soldeCompte
	 *            the soldeCompte to set
	 */
	public void setSoldeCompte(Double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	/**
	 * @return the listeVehicule
	 */
	public List<Vehicule> getListeVehicule() {
		return listeVehicule;
	}

	/**
	 * @param listeVehicule
	 *            the listeVehicule to set
	 */
	public void setListeVehicule(List<Vehicule> listeVehicule) {
		this.listeVehicule = listeVehicule;
	}

	/**
	 * @return the listeCategorie
	 */
	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	/**
	 * @param listeCategorie
	 *            the listeCategorie to set
	 */
	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}
	
	public Membre() {
		super();
		
	}

	public Membre(String nom, String prenom, int matricule, String login, String password, Date dateNaissance,
			String adresse, String email, String sex, Date inscription, String fonction) {
		super(nom, prenom, matricule, login, password, dateNaissance, adresse, email, sex, inscription, fonction);
		this.soldeCompte = (double) connaitreSolde(matricule);
		listeCategorie = CategorieDAO.findAll(matricule);
		listeVehicule = VehiculeDAO.findAll(matricule);
	}
	
	public Membre getMembre(int id) {
		Membre m = null;
		try {
			m = MembreDAO.find(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	public void updateInfo() {
		MembreDAO.update(this);
	}

	public void payerTransaction(Transaction transaction) {
		soldeCompte -= transaction.getValeur();
		MembreDAO.payTransaction(this, transaction);
	}

	public boolean reservationExist(Balade b) {
		return BaladeDAO.reservationExist(this, b);
	}
	
	public boolean propositionExist(Balade b) {
		boolean exist = false;
		List<Vehicule> liste =VehiculeDAO.findVehiculeBalade(b); 
		for(Vehicule v : listeVehicule) {
			for(Vehicule v2 : liste) {
				if(v.getImmatriculation().equals(v2.getImmatriculation())) {
					exist = true;
				}
			}
		}
		return exist;
	}

	public boolean reserverBalade(Balade b, int nbrP, int nbrV) {
		boolean reserver = BaladeDAO.reservation(this, b, nbrP, nbrV);
		if (reserver) {
			soldeCompte += b.getForfait();
			MembreDAO.addTransaction(this, "reservation balade", b.getForfait());
		}
		return reserver;
	}

	public void proposerPlace(Balade b, Vehicule v) {
		VehiculeDAO.propositionVehicule(b, v);
	}

	public void ajouterVehicule(Vehicule vehicule) {
		VehiculeDAO.create(this, vehicule);
	}

	public void retirerVehicule(Vehicule vehicule) {
		VehiculeDAO.delete(vehicule);
	}

	private Double connaitreSolde(int matricule) {
		return MembreDAO.soldeMembre(matricule);
	}

	public boolean ajouterCategorie(Categorie categorie) {
		boolean cat = false;
		if(!listeCategorie.isEmpty() ) {
		listeCategorie.add(categorie);
		categorie.ajouterMembre();
		cat = MembreDAO.addCategorie(this, categorie);
			if(cat) {
				MembreDAO.addTransaction(this, "Cotisation :" + categorie.getNomCategorie(), 5);
				soldeCompte -= 5;
			}
		}
		else{

			listeCategorie = new ArrayList<Categorie>();
			listeCategorie.add(categorie);
			categorie.ajouterMembre();
			cat = MembreDAO.addCategorie(this, categorie);
			MembreDAO.addTransaction(this, "Cotisation :" + categorie.getNomCategorie(), 20);
			soldeCompte -= 20;
		}
		return cat;
	}

	public LinkedList<Balade> getListeBalade() {
		LinkedList<Balade> liste = new LinkedList<Balade>();
		if (!listeCategorie.isEmpty()) {
			for (Categorie c : listeCategorie) {
				liste.addAll(BaladeDAO.findAllBalade(c.getNumCategorie()));
			}

		}
		return liste;
	}
	
	public LinkedList<Balade> getListParticipe(){
		LinkedList<Balade> liste = new LinkedList<Balade>();
		for(Categorie c : listeCategorie) {
			for(Balade b : BaladeDAO.findAllBalade(c.getNumCategorie())) {
				liste.add(b);
			}
		}
		return liste;
	}
	
	public boolean annulerBalade(Balade b) {
		return MembreDAO.annulerBalade(this, b);
	}
	
	public LinkedList<Transaction> compte() {
		LinkedList<Transaction> tabCompte = new LinkedList<Transaction>();
		tabCompte = MembreDAO.tabCompte(this);
		return tabCompte;
	}

}
