package be.Denis.Model;

import java.util.Date;

public class Transaction {
	private int idPersonne;
	private Date dateTransaction;
	private double valeur;
	private String type;
	private boolean payer;
	/**
	 * @return the idPersonne
	 */
	public int getIdPersonne() {
		return idPersonne;
	}
	/**
	 * @return the dateTransaction
	 */
	public Date getDateTransaction() {
		return dateTransaction;
	}
	/**
	 * @return the valeur
	 */
	public double getValeur() {
		return valeur;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the payer
	 */
	public boolean isPayer() {
		return payer;
	}
	public Transaction(int idPersonne, Date dateTransaction, double valeur, String type, boolean payer) {
		super();
		this.idPersonne = idPersonne;
		this.dateTransaction = dateTransaction;
		this.valeur = valeur;
		this.type = type;
		this.payer = payer;
	}
	
}
