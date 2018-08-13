package be.Denis.Model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Balade {
	private int numBalade;
	private String lieu;
	private Date dateBalade;
	private String infoBalade;
	private List<Vehicule> listeVehicule;
	private double forfait;
	private int nbrParticipant;
	private int cat;
	
	private LinkedList<Balade> listBalade;
	
	
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
	public void setForfait(double forfait) {
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
	public Balade(String lieu, Date dateBalade, String infoBalade, double forfait, int cat) {
		super();
		this.lieu = lieu;
		this.dateBalade = dateBalade;
		this.infoBalade = infoBalade;
		this.forfait = forfait;
		this.cat = cat;
	}
	
	/***
	 * Méthodes de la classe
	 */
	public void sauvegarderBalade() {
		// TODO sauvergarder DB
	}
	
	public void ajouterVehiculeBalade(Vehicule vehicule) {
		// TODO mise à jour DB
		listeVehicule.add(vehicule);
	}
	
	public void retirerVehiculeBalade(Vehicule vehicule) {
		// TODO mise à jour DB
		listeVehicule.remove(vehicule);
	}
	
	
}
