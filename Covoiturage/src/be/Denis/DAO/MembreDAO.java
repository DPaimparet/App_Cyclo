package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import be.Denis.Model.Balade;
import be.Denis.Model.Categorie;
import be.Denis.Model.Membre;
import be.Denis.Model.Transaction;

public class MembreDAO extends DAO<Membre> {
	private Long naissance;
	private Long dateToDay;
	private Long dateUtile;

	public MembreDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Membre find(int id) throws ClassNotFoundException, SQLException {
		Membre m = null;

		String req = "SELECT * FROM personne WHERE id = ? ";
		try {
			PreparedStatement prepare = connect.prepareStatement(req);
			prepare.setInt(1, id);
			ResultSet resultat = prepare.executeQuery();
			while (resultat.next()) {
				dateUtile = resultat.getLong("dateNaissance");
				Date date = new Date(dateUtile);

				dateToDay = resultat.getLong("dateInscription");
				Date dateInscript = new Date(dateToDay);

				// String nom, String prenom, int matricule, String login, String password, Date
				// dateNaissance,
				// String adresse, String email, String sex, Date inscription, String fonction
				m = new Membre(resultat.getString("nom"), resultat.getString("prenom"), resultat.getInt("idPersonne"),
						resultat.getString("login"), resultat.getString("mdp"), date, resultat.getString("adresse"),
						resultat.getString("mail"), resultat.getString("sex"), dateInscript,
						resultat.getString("fonction"));
			}

		} catch (SQLException e) {
			return null;
		}
		return m;
	}

	@Override
	public boolean create(Membre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Membre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Membre obj) {
		naissance = obj.getDateNaissance().getTime();
		try {
			String updateMembre = "UPDATE membre " + "SET "
					+ "nom = ?, prenom = ? , login = ?, mdp = ?, dateNaissance = ?, sex = ?, adresse = ?, mail = ?, fonction = ?, soldeCompte = ?"
					+ " Where idPersonne = " + obj.getMatricule();

			PreparedStatement prepare = connect.prepareStatement(updateMembre);
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getPrenom());
			prepare.setString(3, obj.getLogin());
			prepare.setString(4, obj.getPassword());
			prepare.setLong(5, naissance);
			prepare.setString(6, obj.getSex());
			prepare.setString(7, obj.getAdresse());
			prepare.setString(8, obj.getEmail());
			prepare.setString(9, obj.getFonction());
			prepare.setDouble(10, obj.getSoldeCompte());
			prepare.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return false;
		}
		return true;
	}

	@Override
	public LinkedList<Membre> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double soldeMembre(int matricule) {
		Double solde = null;
		try {
			String reqSolde = "SELECT soldeCompte FROM membre WHERE idPersonne = ?";
			PreparedStatement prepare = connect.prepareStatement(reqSolde);
			prepare.setInt(1, matricule);
			ResultSet resultat = prepare.executeQuery();

			if (resultat.next()) {
				solde = resultat.getDouble("soldeCompte");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connection base de donnees " + e);
		}
		return solde;

	}

	public List<Categorie> listCat(int id) {
		List<Categorie> listeCat = null;
		CategorieDAO cat = new CategorieDAO(connect);
		listeCat = cat.findAll(id);
		return listeCat;
	}

	public boolean addCategorie(Membre membre, Categorie categorie) {
		int annee = Calendar.getInstance().get(Calendar.YEAR);
		try {
			String insertCat = "INSERT INTO personne_categorie " + "(idCategorie, idPersonne, annee)"
					+ " VALUES (?,?,?)";

			PreparedStatement prepare = connect.prepareStatement(insertCat);
			prepare.setInt(1, categorie.getNumCategorie());
			prepare.setInt(2, membre.getMatricule());
			prepare.setInt(3, annee);
			prepare.executeUpdate();
			prepare.close();

		} catch (SQLException e) {
			System.out.print(e);
			JOptionPane.showMessageDialog(null, "Erreur base de donnees " + e);
			return false;
		}
		return true;
	}

	public boolean addTransaction(Membre obj, String type, double montant) {
		dateToDay = new Date().getTime();
		try {
			String reqTransaction = "INSERT INTO transaction" + " (idPersonne, dateTransaction, valeur, type, payer)"
					+ " VALUES (?,?,?,?,?)";
			PreparedStatement prepare = connect.prepareStatement(reqTransaction);
			prepare.setInt(1, obj.getMatricule());
			prepare.setLong(2, dateToDay);
			prepare.setDouble(3, montant);
			prepare.setString(4, type);
			prepare.setBoolean(5, false);
			prepare.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur base de donnees " + e);
			return false;
		}

		return true;
	}

	public boolean annulerBalade(Membre m, Balade b) {
		// String reqAnnulationProposition = "DELETE FROM vehicule_balade WHERE idBalade
		// = ? AND idVehicule =";
		String reqAnnulationReservation = "DELETE FROM reservation WHERE idBalade = ? AND idPersonne = ?";
		try {
			PreparedStatement prepare = connect.prepareStatement(reqAnnulationReservation);
			prepare.setInt(0, b.getNumBalade());
			prepare.setInt(2, m.getMatricule());
			prepare.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur base de donnees " + e);
		}

		return true;
	}

	public LinkedList<Transaction> tabCompte(Membre m) {
		Long date;
		String req = "SELECT * FROM transaction WHERE idPersonne = ?";
		LinkedList<Transaction> tab = new LinkedList<Transaction>();
		try {
			PreparedStatement prepare = connect.prepareStatement(req);
			prepare.setInt(1, m.getMatricule());

			ResultSet resultat = prepare.executeQuery();
			while (resultat.next()) {
				date = resultat.getLong("dateTransaction");
				Date dateTransaction = new Date(date);

				tab.add(new Transaction(m.getMatricule(), dateTransaction, resultat.getDouble("valeur"),
						resultat.getString("type"), resultat.getBoolean("payer")));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur base de donnees " + e);
			return null;
		}

		return tab;
	}

	public boolean payTransaction(Membre m, Transaction t) {
		dateUtile = t.getDateTransaction().getTime();
		// UPDATE TestTable set myNumericBooleanColumn = 1;
		String req = "UPDATE transaction SET payer = -1 WHERE idPersonne = ? AND type = ? AND dateTransaction = ? ";
		try {
			PreparedStatement prepare = connect.prepareStatement(req);
			prepare.setInt(1, m.getMatricule());
			prepare.setString(2, t.getType());
			prepare.setLong(3, dateUtile);
			prepare.executeUpdate();
			JOptionPane.showMessageDialog(null, "Paiement effectué");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur base de donnees " + e);
			return false;
		}
		return true;
	}
}
