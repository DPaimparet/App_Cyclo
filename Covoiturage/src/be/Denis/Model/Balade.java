package be.Denis.Model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;

public class Balade {
	private int numBalade;
	private String lieu;
	private Date dateBalade;
	private String infoBalade;
	private List<Vehicule> listeVehicule;
	private Double forfait;
	private int nbrParticipant;
	private int cat;

	private LinkedList<Balade> listBalade;
	
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAO<Balade> BaladeDAO = adf.getBaladeDAO();
	
	
	/***
	 * Getter and Setter
	 */
	/**
	 * @return the numBalade
	 */
	public int getNumBalade() {
		return numBalade;
	}
	/**
	 * @param numBalade the numBalade to set
	 */
	public void setNumBalade(int numBalade) {
		this.numBalade = numBalade;
	}
	/**
	 * @return the cat
	 */
	public int getCat() {
		return cat;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDateBalade() {
		return dateBalade;
	}
	public void setDateBalade(Date dateBalade) {
		this.dateBalade = dateBalade;
	}
	public String getInfoBalade() {
		return infoBalade;
	}
	public void setInfoBalade(String infoBalade) {
		this.infoBalade = infoBalade;
	}
	public List<Vehicule> getListeVehicule() {
		return listeVehicule;
	}
	public void setListeVehicul(List<Vehicule> listeVehicule) {
		this.listeVehicule = listeVehicule;
	}
	public double getForfait() {
		return forfait;
	}
	public void setForfait(Double forfait) {
		this.forfait = forfait;
	}
	public int getNbrParticipant() {
		return nbrParticipant;
	}
	public void setNbrParticipant(int nbrParticipant) {
		this.nbrParticipant = nbrParticipant;
	}
	

	/***
	 * Constructeur
	 * @param lieu
	 * @param dateBalade
	 * @param infoBalade
	 * @param forfait
	 * @param cat
	 */
	public Balade(String lieu, Date dateBalade, String infoBalade, Double forfait, int cat) {
		super();
		this.lieu = lieu;
		this.dateBalade = dateBalade;
		this.infoBalade = infoBalade;
		this.forfait = forfait;
		this.cat = cat;
	}
	
	public Balade(int numBalade, String lieu, Date dateBalade, String infoBalade, int nbrParticipant, Double forfait, int cat) {
		super();
		this.numBalade = numBalade;
		this.lieu = lieu;
		this.dateBalade = dateBalade;
		this.infoBalade = infoBalade;
		this.forfait = forfait;
		this.nbrParticipant = nbrParticipant;
		this.cat = cat;
	}
	/***
	 * Méthodes de la classe
	 */
	public void sauvegarderBalade() {
		BaladeDAO.create(this);
	}
	
	public void ajouterVehiculeBalade(Vehicule vehicule) {
		// TODO mise à jour DB
		listeVehicule.add(vehicule);
	}
	
	public void retirerVehiculeBalade(Vehicule vehicule) {
		// TODO mise à jour DB
		listeVehicule.remove(vehicule);
	}
	
	public void supprimerBalade() {
		BaladeDAO.delete(this);
	}
	
	public boolean equals(Balade a1){
		if (this.numBalade==a1.numBalade) {
			a1 = this;
			return true;
		}
		return false;
	}
	
	public boolean updateBalade() {
		BaladeDAO.update(this);
		return false;
	}
}
