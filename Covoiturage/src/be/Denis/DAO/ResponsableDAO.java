package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import be.Denis.Model.Responsable;

public class ResponsableDAO extends DAO<Responsable>{
	
	private Long naissance;
	
	public ResponsableDAO(Connection conn){
		super(conn);
	}

	@Override
	public boolean create(Responsable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Responsable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Responsable obj) {
		naissance = obj.getDateNaissance().getTime();
		try{
			String updateResponsable = "UPDATE membre " 
					+ "SET "
					+ "nom = ?, prenom = ? , login = ?, mdp = ?, dateNaissance = ?, sex = ?, adresse = ?, mail = ?, fonction = ?"
					+ " Where idPersonne = " + obj.getMatricule();

			PreparedStatement prepare = connect.prepareStatement(updateResponsable);
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
	public Responsable find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Responsable> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addCategorie(Responsable obj) {
		System.out.println("ajout cat Responsable DAO");
		@SuppressWarnings("deprecation")
		int annee = new Date().getYear();
		try{
			String selectCatResponsable = "SELECT * FROM personne_categorie WHERE idCategorie = ? AND idPersonne = ?";
			
			String insertCat = "INSERT INTO personne_categorie "
					+ "(idCategorie, idPersonne, annee)"
					+ "VALUES (?,?,?)";
			
			String updateResponsable = "UPDATE personne_categorie " 
					+ "SET "
					+ "idCategorie = ? , idPersonne = ? , annee = ?"
					+ " Where idPersonne = " + obj.getMatricule() + " AND idCategorie = " + obj.getCat().getNumCategorie();
			
			PreparedStatement stmtSelect = connect.prepareStatement(selectCatResponsable);
			PreparedStatement stmtInsert = connect.prepareStatement(insertCat);
			PreparedStatement stmtUpdate = connect.prepareStatement(updateResponsable);
			
			stmtSelect.setInt(1, obj.getCat().getNumCategorie());
			stmtSelect.setInt(2, obj.getMatricule());
			ResultSet res = stmtSelect.executeQuery();
			if(res.next()) {
				stmtUpdate.setInt(1, obj.getCat().getNumCategorie());
				stmtUpdate.setInt(2, obj.getMatricule());
				stmtUpdate.setInt(3, annee);
				stmtUpdate.executeUpdate();
				stmtUpdate.close();
				res.close();
			}
			else {
				stmtInsert.setInt(1, obj.getCat().getNumCategorie());
				stmtInsert.setInt(2, obj.getMatricule());
				stmtInsert.setInt(3, annee);
				stmtInsert.executeUpdate();
				stmtInsert.close();
			}
			stmtSelect.close();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donnees");
			return false;
		} 
		return true;
	}
}