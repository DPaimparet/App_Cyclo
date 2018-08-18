package be.Denis.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
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
	
	public boolean create(Balade obj, int numResponsable) {
		return false;
	}
	
	public LinkedList<Membre> GetListMon() {
		return null;
	}
	
	public LinkedList<Balade> findAllBalade(int i){
		return null;
	}
	
	public Float soldeMembre(int matricule) {
		return null;
	}

	public boolean addCategorie(Responsable responsable) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void reservation(Membre membre, int nbrP, int nbrV) {
		
	}
	
	
}