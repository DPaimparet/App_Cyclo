package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import be.Denis.Model.Membre;

public class MembreDAO extends DAO<Membre>{
	private Long naissance;
	
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
	public LinkedList<Membre> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Float soldeMembre(int matricule) {
		Float solde = null;
		try{
			String reqSolde = "SELECT soldeCompte FROM membre WHERE idPersonne = ?";
			PreparedStatement prepare = connect.prepareStatement(reqSolde);
			prepare.setInt(1, matricule);
			ResultSet resultat = prepare.executeQuery();
			
			if(resultat.next()) {
				solde = resultat.getFloat("soldeCompte");
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erreur de connection base de donnees " + e);
		} 
		return solde;
		
	}
	
}
