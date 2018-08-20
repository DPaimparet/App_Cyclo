package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import be.Denis.Model.Transaction;
import be.Denis.Model.Tresorier;

public class TresorierDAO extends DAO<Tresorier> {
	private Long naissance;
	
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
		naissance = obj.getDateNaissance().getTime();
		try{
			String updateMembre = "UPDATE membre " 
					+ "SET "
					+ "nom = ?, prenom = ? , login = ?, mdp = ?, dateNaissance = ?, sex = ?, adresse = ?, mail = ?, fonction = ?"
					+ " Where idPersonne = " + obj.getMatricule();

			PreparedStatement prepare = connect.prepareStatement(updateMembre);
		    prepare.setString (1, obj.getNom());
		    prepare.setString (2, obj.getPrenom());
		    prepare.setString(3, obj.getLogin());
		    prepare.setString(4, obj.getPassword());
		    prepare.setLong(5, naissance);
		    prepare.setString(6, obj.getSex());
		    prepare.setString(7, obj.getAdresse());
		    prepare.setString(8, obj.getEmail());
		    prepare.setString(9, obj.getFonction());
		    prepare.executeUpdate();

		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return false;
		} 
		return true;
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
	
	public LinkedList<Transaction> getListeDeplacement(){
		Long date;
		LinkedList<Transaction> liste = new LinkedList<Transaction>();
		String reqList = "SELECT * FROM transaction T INNER JOIN membre M "
				+ "ON  T.idPersonne = M.idPersonne"
				+ " WHERE type = \"reservation balade\" ";
		try {
			PreparedStatement prepare = connect.prepareStatement(reqList);
			ResultSet resultat = prepare.executeQuery();
			while(resultat.next()) {
				date = resultat.getLong("dateTransaction");
				Date dateTransaction = new Date(date);
				liste.add(new Transaction(resultat.getInt("idPersonne"), dateTransaction, resultat.getDouble("valeur"), resultat.getString("type"), resultat.getBoolean("payer")));
			}
		}catch(SQLException e) {
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return null;
		}
		return liste;
	}

}
