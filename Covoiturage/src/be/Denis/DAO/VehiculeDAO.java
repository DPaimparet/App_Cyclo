package be.Denis.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Vehicule;

public class VehiculeDAO extends DAO<Vehicule> {

	public VehiculeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Vehicule obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vehicule obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehicule obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Vehicule> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicule find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
