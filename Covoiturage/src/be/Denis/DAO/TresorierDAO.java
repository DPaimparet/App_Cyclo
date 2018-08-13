package be.Denis.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import be.Denis.Model.Tresorier;

public class TresorierDAO extends DAO<Tresorier> {

	public TresorierDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Tresorier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Tresorier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Tresorier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Tresorier> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tresorier find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
