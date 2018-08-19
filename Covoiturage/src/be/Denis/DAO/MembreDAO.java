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

import be.Denis.Model.Categorie;
import be.Denis.Model.Membre;


public class MembreDAO extends DAO<Membre>{
	private Long naissance;
	private Long dateToDay;
	
	public MembreDAO(Connection conn){
		super(conn);
	}

	@Override
	public Membre find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
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
			try{
				String updateMembre = "UPDATE membre " 
						+ "SET "
						+ "nom = ?, prenom = ? , login = ?, mdp = ?, dateNaissance = ?, sex = ?, adresse = ?, mail = ?, fonction = ?, soldeCompte = ?"
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
			    prepare.setDouble(10, obj.getSoldeCompte());
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
	public LinkedList<Membre> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Double soldeMembre(int matricule) {
		Double solde = null;
		try{
			String reqSolde = "SELECT soldeCompte FROM membre WHERE idPersonne = ?";
			PreparedStatement prepare = connect.prepareStatement(reqSolde);
			prepare.setInt(1, matricule);
			ResultSet resultat = prepare.executeQuery();
			
			if(resultat.next()) {
				solde = resultat.getDouble("soldeCompte");
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erreur de connection base de donnees " + e);
		} 
		return solde;
		
	}
	
	public List<Categorie> listCat(int id){
		List<Categorie> listeCat = null;
		CategorieDAO cat = new CategorieDAO(connect);
		listeCat = cat.findAll(id);
		return listeCat;
	}
	
	public boolean addCategorie(Membre membre, Categorie categorie) {
		int annee = Calendar.getInstance().get(Calendar.YEAR);
		try{
			String insertCat = "INSERT INTO personne_categorie "
					+ "(idCategorie, idPersonne, annee)"
					+ " VALUES (?,?,?)";
			
			PreparedStatement prepare = connect.prepareStatement(insertCat);
			prepare.setInt(1, categorie.getNumCategorie());
			prepare.setInt(2, membre.getMatricule());
			prepare.setInt(3, annee);
			prepare.executeUpdate();
			prepare.close();

		}
		catch(SQLException e){
			System.out.print(e);
			JOptionPane.showMessageDialog(null, "Erreur base de donnees " + e);
			return false;
		} 
		return true;
	}
	
	public boolean addTransaction(Membre obj, String type, double montant) {
		dateToDay = new Date().getTime();
		try {
			String reqTransaction = "INSERT INTO transaction"
					+"(idPersonne, dateTransaction, valeur, type, payer)"
					+"VALUES (?,?,?,?,?)";
			PreparedStatement prepare = connect.prepareStatement(reqTransaction);
			prepare.setInt(1, obj.getMatricule());
			prepare.setLong(2, dateToDay);
			prepare.setDouble(3, montant);
			prepare.setString(4, type);
			prepare.setBoolean(5, false);
			prepare.executeUpdate();
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erreur base de donnees " + e);
			return false;
		}
		
		return true;
	}
	
}
