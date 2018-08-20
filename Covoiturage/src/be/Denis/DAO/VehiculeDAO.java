package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import be.Denis.Model.Balade;
import be.Denis.Model.Membre;
import be.Denis.Model.Vehicule;

public class VehiculeDAO extends DAO<Vehicule> {

	public VehiculeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Membre membre, Vehicule obj) {
		String creerMembre = "INSERT INTO vehicule"
				+ " (idPersonne, immatriculation, marque, model, placePersonne, PlaceVelo ) " + " VALUES"
				+ "(?,?,?,?,?,?)";
		try {
			PreparedStatement prepare = connect.prepareStatement(creerMembre);
			prepare.setInt(1, membre.getMatricule());
			prepare.setString(2, obj.getImmatriculation());
			prepare.setString(3, obj.getMarque());
			prepare.setString(4, obj.getModel());
			prepare.setInt(5, obj.getNbrPlacePersonne());
			prepare.setInt(6, obj.getNbrPlaceVelo());
			prepare.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Le vehicule " + obj.getMarque() + " " + obj.getModel() + " a �t� ajout�" );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "VehiculeDAO : " + e);
			return false;
		}

		return false;
	}

	@Override
	public boolean delete(Vehicule obj) {
		String reqDelete = "DELETE FROM vehicule WHERE immatriculation = ?";
		try {
			PreparedStatement prepare = connect.prepareStatement(reqDelete);
			prepare.setString(1, obj.getImmatriculation());
			prepare.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Le vehicule " + obj.getMarque() + " " + obj.getModel() + " a �t� supprim�" );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "VehiculeDAO : " + e);
			return false;
		}

		return false;
	}

	@Override
	public boolean update(Vehicule obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Vehicule> findAll(int id) {
		LinkedList<Vehicule> liste = new LinkedList<Vehicule>();
		String reqListe = "SELECT immatriculation, marque, model, placePersonne, placeVelo"
				+ " FROM vehicule"
				+ " WHERE idPersonne = ?";
		try {
			PreparedStatement prepare = connect.prepareStatement(reqListe);
			prepare.setInt(1, id);
			ResultSet resultat = prepare.executeQuery();
			while (resultat.next()) {
				liste.add(new Vehicule(resultat.getString("immatriculation"), resultat.getString("marque"),
						resultat.getString("model"), resultat.getInt("placePersonne"), resultat.getInt("placeVelo")));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return liste;
	}
	
	public LinkedList<Vehicule> findVehiculeBalade(Balade obj)  {
		LinkedList<Vehicule> liste = new LinkedList<Vehicule>();
		String reqListe = "SELECT immatriculation, marque, model, placePersonne, placeVelo"
				+ " FROM vehicule V"
				+ " INNER JOIN vehicule_balade VB"
				+ " ON V.idVehicule = VB.idVehicule"
				+ " WHERE idBalade = ?";
		try {
			PreparedStatement prepare = connect.prepareStatement(reqListe);
			prepare.setInt(1, obj.getNumBalade());
			ResultSet resultat = prepare.executeQuery();
			while (resultat.next()) {
				liste.add(new Vehicule(resultat.getString("immatriculation"), resultat.getString("marque"),
						resultat.getString("model"), resultat.getInt("placePersonne"), resultat.getInt("placeVelo")));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return liste;
	}

	@Override
	public Vehicule find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Vehicule obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean propositionVehicule(Balade b, Vehicule v) {
		int idVehicule = 0;
		String reqVehicule = "SELECT idVehicule FROM vehicule WHERE immatriculation = ?";
		String reqProposition = "INSERT INTO vehicule_balade "
								+ " (idVehicule, idBalade, nbrPersonne, nbrVelo )"
								+ " VALUES (?,?,?,?)";
		try {
			PreparedStatement prepare = connect.prepareStatement(reqVehicule);
			prepare.setString(1, v.getImmatriculation());
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next()) {
				idVehicule = resultat.getInt("idVehicule");
			}
			
			PreparedStatement stmt = connect.prepareStatement(reqProposition);
			stmt.setInt(1, idVehicule);
			stmt.setInt(2, b.getNumBalade());
			stmt.setInt(3, v.getNbrPlacePersonne());
			stmt.setInt(4, v.getNbrPlaceVelo());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "La participation du v�hicule " + v.getMarque() + " " + v.getModel() + " a bien �t� enregistr�");

		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
		return true;
	}

}
