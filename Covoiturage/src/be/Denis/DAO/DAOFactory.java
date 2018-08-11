package be.Denis.DAO;

import java.sql.Connection;

import be.Denis.Model.Balade;
import be.Denis.Model.Membre;
import be.Denis.Model.Personne;
import be.Denis.Model.Responsable;

public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = AccessDB.getInstance();
	
	public DAO<Personne> getPersonneDAO() {
		return new PersonneDAO(conn);
	}
	
	public DAO<Membre> getMembreDAO() {
		return new MembreDAO(conn);
	}
	
	public DAO<Responsable> getResponsableDAO() {
		return new ResponsableDAO(conn);
	}
	
	public DAO<Balade> getBaladeDAO() {
		return new BaladeDAO(conn);
	}

}