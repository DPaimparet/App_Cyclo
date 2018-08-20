package be.Denis.Model;

public class Vehicule {
	private String immatriculation;
	private String marque;
	private String model;
	private int nbrPlacePersonne;
	private int nbrPlaceVelo;
	/**
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}
	/**
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}
	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the nbrPlacePersonne
	 */
	public int getNbrPlacePersonne() {
		return nbrPlacePersonne;
	}
	/**
	 * @param nbrPlacePersonne the nbrPlacePersonne to set
	 */
	public void setNbrPlacePersonne(int nbrPlacePersonne) {
		this.nbrPlacePersonne = nbrPlacePersonne;
	}
	/**
	 * @return the nbrPlaceVelo
	 */
	public int getNbrPlaceVelo() {
		return nbrPlaceVelo;
	}
	/**
	 * @param nbrPlaceVelo the nbrPlaceVelo to set
	 */
	public void setNbrPlaceVelo(int nbrPlaceVelo) {
		this.nbrPlaceVelo = nbrPlaceVelo;
	}
	
	public Vehicule(String immatriculation, String marque, String model, int nbrPlacePersonne, int nbrPlaceVelo) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.model = model;
		this.nbrPlacePersonne = nbrPlacePersonne;
		this.nbrPlaceVelo = nbrPlaceVelo;
	}
	
	public boolean equals(Vehicule v){
		if (this.immatriculation == v.immatriculation) {
			v = this;
			return true;
		}
		return false;
	}
	
	

}
