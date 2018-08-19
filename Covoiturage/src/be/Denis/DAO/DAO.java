package be.Denis.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import be.Denis.Model.*;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract LinkedList<T> findAll(int id);

	public abstract T find(int id) throws ClassNotFoundException, SQLException;
	
	public T find(String login,String pass) throws ClassNotFoundException, SQLException {
		return null;
	}
	
	public boolean compteExist(String login, String email) {
		return false;
	}
	
	public LinkedList<Balade> findAllBalade(int i){
		return null;
	}
	
	public Double soldeMembre(int matricule) {
		return null;
	}

	public boolean addCategorie(Responsable responsable) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean reservation(Membre membre, Balade balade, int nbrP, int nbrV) {
		return false;
	}
	
	public List<Categorie> listCat(int id){
		return null;
	}

	public boolean addCategorie(Membre membre, Categorie categorie) {
		return false;
	}
	
	public boolean addTransaction(Membre obj, String type, double montant) {
		return false;
	}
	
	public boolean reservationExist(Membre obj, Balade balade) {
		return false;
	}

	public boolean create(Membre membre, Vehicule obj) {
		return false;
	}
}