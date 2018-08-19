package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

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
			
			JOptionPane.showMessageDialog(null, "Le vehicule " + obj.getMarque() + " " + obj.getModel() + " a été ajouté" );
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
			
			JOptionPane.showMessageDialog(null, "Le vehicule " + obj.getMarque() + " " + obj.getModel() + " a été ajouté" );
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

}
