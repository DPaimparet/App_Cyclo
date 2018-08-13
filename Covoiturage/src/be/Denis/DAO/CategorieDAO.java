package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
		// TODO Auto-generated method stub
		return null;
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
					System.out.println(nomCat);
					categorie = new Cyclo(nomCat);
				}
				if(nomCat.equals("descendeur")) {
					System.out.println(nomCat);
					categorie = new Cyclo(nomCat);
				}
				if(nomCat.equals("randonneur")) {
					System.out.println(nomCat);
					categorie = new Cyclo(nomCat);
				}
				if(nomCat.equals("trialiste")) {
					System.out.println(nomCat);
					categorie = new Cyclo(nomCat);
				}
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "CategorieDAO : " + e);
		}
		return categorie;
	}

}
