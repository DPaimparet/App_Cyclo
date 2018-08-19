package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import be.Denis.Model.Categorie;
import be.Denis.Model.Cyclo;
import be.Denis.Model.Descente;
import be.Denis.Model.Randonneur;
import be.Denis.Model.Trialiste;

public class CategorieDAO extends DAO<Categorie>{

	public CategorieDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Categorie> findAll(int id) {
		int annee = Calendar.getInstance().get(Calendar.YEAR);
		LinkedList<Categorie> listeCat = new LinkedList<Categorie>();
		Categorie categorie = null;
		String nomCat;
		String req = "SELECT C.idCategorie, C.categorie, P.annee "
				+"FROM categorie C INNER JOIN personne_categorie P "
				+"ON C.idCategorie = P.idCategorie "
				+"WHERE idPersonne = ? AND annee = ?";
		try {
			PreparedStatement prepare = connect.prepareStatement(req);
			prepare.setInt(1, id);
			prepare.setInt(2, annee);
			ResultSet resultat = prepare.executeQuery();
			
			while(resultat.next()) {
				nomCat = resultat.getString("categorie");
				if(nomCat.equals("route")) {
					categorie = new Cyclo(nomCat);
				}
				if(nomCat.equals("descendeur")) {
					categorie = new Descente(nomCat);
				}
				if(nomCat.equals("randonneur")) {
					categorie = new Randonneur(nomCat);
				}
				if(nomCat.equals("trialiste")) {
					categorie = new Trialiste(nomCat);
				}
				listeCat.add(categorie);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "CategorieDAO : " + e);
		}
		
		return listeCat;
	}

	@Override
	public Categorie find(int id){
		Categorie categorie = null;
		String nomCat;
		try {
			String req = "SELECT C.idCategorie, C.categorie, P.annee "
					+"FROM categorie C INNER JOIN personne_categorie P "
					+"ON C.idCategorie = P.idCategorie "
					+"WHERE idPersonne = ?";
			
			PreparedStatement prepare = connect.prepareStatement(req);
			prepare.setInt(1, id);
			ResultSet resultat = prepare.executeQuery();
			
			if(resultat.next()) {
				nomCat = resultat.getString("categorie");
				if(nomCat.equals("route")) {
					categorie = new Cyclo(nomCat);
				}
				if(nomCat.equals("descendeur")) {
					categorie = new Descente(nomCat);
				}
				if(nomCat.equals("randonneur")) {
					categorie = new Randonneur(nomCat);
				}
				if(nomCat.equals("trialiste")) {
					categorie = new Trialiste(nomCat);
				}
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "CategorieDAO : " + e);
		}
		return categorie;
	}

}
