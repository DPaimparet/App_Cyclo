package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import be.Denis.Model.Balade;
import be.Denis.Model.Membre;
import be.Denis.Model.Vehicule;

public class BaladeDAO extends DAO<Balade> {
	int idGenere;
	String dateInString;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date dateMessage = new Date();
	Long dateLong = null;

	public BaladeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Balade obj) {
		Long date;
		try {
			date = obj.getDateBalade().getTime();
			String creerBalade = "INSERT INTO Balade" + " (idCategorie, lieu, dateBalade, description, forfait ) "
					+ "VALUES" + "(?,?,?,?,?)";

			PreparedStatement prepare = connect.prepareStatement(creerBalade);
			prepare.setInt(1, obj.getCat());
			prepare.setString(2, obj.getLieu());
			prepare.setLong(3, date);
			prepare.setString(4, obj.getInfoBalade());
			prepare.setDouble(5, obj.getForfait());
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			while (rs.next()) {
				idGenere = rs.getInt(1);
				obj.setNumBalade(idGenere);
			}
			JOptionPane.showMessageDialog(null, "La balade a bien été créé");
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Balade obj) {
		try {
			dateInString = formatter.format(obj.getDateBalade());
			String reqDelete = "DELETE FROM balade WHERE idBalade = ?";
			PreparedStatement prepare = connect.prepareStatement(reqDelete);
			prepare.setInt(1, obj.getNumBalade());
			prepare.executeUpdate();
			JOptionPane.showMessageDialog(null,
					"La balade du " + dateInString + " à " + obj.getLieu() + " a bien été supprimée");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Balade obj) {
		try {
			Long date;
			date = obj.getDateBalade().getTime();
			dateInString = formatter.format(obj.getDateBalade());
			String updateResponsable = "UPDATE balade "
					+ "SET lieu = ?, dateBalade = ?, description = ?, forfait = ?, nbrParticipant = ?"
					+ " Where idBalade = ?";

			PreparedStatement prepare = connect.prepareStatement(updateResponsable);
			prepare.setString(1, obj.getLieu());
			prepare.setLong(2, date);
			prepare.setString(3, obj.getInfoBalade());
			prepare.setDouble(4, obj.getForfait());
			prepare.setInt(5, obj.getNbrParticipant());
			prepare.setInt(6, obj.getNumBalade());
			prepare.executeUpdate();

			JOptionPane.showMessageDialog(null,
					"La balade du " + dateInString + " à " + obj.getLieu() + " a bien été mis à jour");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Balade find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Balade> findAll(int id) {
		LinkedList<Balade> listBalade = new LinkedList<Balade>();
		List<Integer> listId = new ArrayList<>();
		Long dateLong = null;
		try {
			String reqListBalade = "SELECT"
					+ " balade.idBalade, lieu, dateBalade, description, nbrParticipant, forfait, idCategorie"
					+ " FROM balade INNER JOIN reservation ON (balade.idBalade = reservation.idBalade)"
					+ " WHERE idPersonne = ?" + " ORDER BY dateBalade";
			PreparedStatement prepare = connect.prepareStatement(reqListBalade);
			prepare.setInt(1, id);
			ResultSet resultat = prepare.executeQuery();
			while (resultat.next()) {
				dateLong = resultat.getLong("dateBalade");
				Date dateBalade = new Date(dateLong);
				listBalade.add(new Balade(resultat.getInt("idBalade"), resultat.getString("lieu"), dateBalade,
						resultat.getString("description"), resultat.getInt("nbrParticipant"),
						resultat.getDouble("forfait"), resultat.getInt("idCategorie")));
			}

			String reqListeBaladeVehicule = "SELECT * FROM vehicule WHERE idPersonne = ?";
			PreparedStatement prepare2 = connect.prepareStatement(reqListeBaladeVehicule);
			prepare2.setInt(1, id);
			ResultSet resultat2 = prepare2.executeQuery();
			while (resultat2.next()) {
				listId.add(resultat2.getInt("idVehicule"));
			}

			for (int idVehicule : listId) {
				String reqListeReservation = "SELECT B.idBalade, lieu, dateBalade, description, nbrParticipant, forfait, idCategorie"
						+ " FROM balade B INNER JOIN vehicule_balade V ON B.idBalade = V.idBalade WHERE idVehicule = ?";
				PreparedStatement prepare3 = connect.prepareStatement(reqListeReservation);
				prepare3.setInt(1, idVehicule);
				ResultSet resultat3 = prepare3.executeQuery();
				while (resultat3.next()) {
					dateLong = resultat.getLong("dateBalade");
					Date dateBalade = new Date(dateLong);
					listBalade.add(new Balade(resultat.getInt("idBalade"), resultat.getString("lieu"), dateBalade,
							resultat.getString("description"), resultat.getInt("nbrParticipant"),
							resultat.getDouble("forfait"), resultat.getInt("idCategorie")));
					prepare3.close();
				}
			}
			prepare.close();
			prepare2.close();

		} catch (SQLException e) {
			System.out.println("Erreur de connection base de données" + e);
		}
		return listBalade;
	}

	public LinkedList<Balade> findAllBalade(int categorie) {
		LinkedList<Balade> listBalade = new LinkedList<Balade>();
		Long dateLong = null;
		try {
			String reqListBalade = "SELECT * FROM Balade WHERE idCategorie = ? ORDER BY dateBalade";
			PreparedStatement prepare = connect.prepareStatement(reqListBalade);
			prepare.setInt(1, categorie);
			ResultSet resultat = prepare.executeQuery();
			while (resultat.next()) {
				dateLong = resultat.getLong("dateBalade");
				Date dateBalade = new Date(dateLong);
				listBalade.add(new Balade(resultat.getInt("idBalade"), resultat.getString("lieu"), dateBalade,
						resultat.getString("description"), resultat.getInt("nbrParticipant"),
						resultat.getDouble("forfait"), categorie));
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return listBalade;

	}

	public boolean reservationExist(Membre obj, Balade balade) {
		boolean reservation = false;
		String reqResExit = "SELECT * FROM reservation WHERE idBalade = ? AND idPersonne = ?";
		try {
			PreparedStatement stmt = connect.prepareStatement(reqResExit);
			stmt.setInt(1, balade.getNumBalade());
			stmt.setInt(2, obj.getMatricule());

			ResultSet resultat = stmt.executeQuery();
			if (resultat.next()) {
				reservation = true;
			}

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return reservation;
	}

	public boolean reservation(Membre obj, Balade balade, int nbrP, int nbrV) {
		dateInString = formatter.format(balade.getDateBalade());
		try {
			String reqReservation = "INSERT INTO reservation"
					+" (idPersonne, idBalade, nbrPersonne, nbrVelo)"
					+" VALUES (?,?,?,?)";
			PreparedStatement prepare = connect.prepareStatement(reqReservation);
			prepare.setInt(1, obj.getMatricule());
			prepare.setInt(2, balade.getNumBalade());
			prepare.setInt(3, nbrP);
			prepare.setInt(4, nbrV);
			prepare.executeUpdate();
			JOptionPane.showMessageDialog(null,
					"La balade du " + dateInString + " à " + balade.getLieu() + " a bien été mis à jour");
			prepare.close();
			
		}
		catch(SQLException e){
			System.out.println(e);
			return false;
		}
		return true;
	}

}