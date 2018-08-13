package be.Denis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import be.Denis.Model.Personne;

public class PersonneDAO extends DAO<Personne>{
	private Long naissance;
	private Long inscription;
	
	public PersonneDAO(Connection conn){
		super(conn);
	}
	
	/***
	 * Recherche de la personne à la connexion
	 */
		public Personne find(String login, String pass){
			Personne personne = null;
			try {
				String membre = "SELECT * FROM membre WHERE login = ? AND mdp = ? OR mail = ? AND mdp = ?";
				PreparedStatement prepare = connect.prepareStatement(membre);
				prepare.setString (1, login);
				prepare.setString (2, pass);
				prepare.setString (3, login);
				prepare.setString (4, pass);
				ResultSet resultat = prepare.executeQuery();
				
				if(resultat.next()) {
					
					naissance = resultat.getLong("dateNaissance");
					inscription = resultat.getLong("dateInscription");
					
					Date dateNaissance = new Date(naissance);
					Date dateInscription = new Date(inscription);
					
					personne = new Personne(resultat.getString("nom"), resultat.getString("prenom"), resultat.getInt("idPersonne"), resultat.getString("login"), resultat.getString("mdp"),
							dateNaissance, resultat.getString("adresse"), resultat.getString("mail"), resultat.getString("sex"), dateInscription ,
							resultat.getString("fonction"));
					
					return personne;
				}
			}
			catch(SQLException e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "PersonneDAO : " + e);
			}
			return personne;
		}
		
	/***
	 * Création d'une nouvelle personne dans la base de données
	 */
	@Override
	public boolean create(Personne obj) {
		try{
			naissance = obj.getDateNaissance().getTime();
			inscription = obj.getInscription().getTime();
	
			String creerMembre = "INSERT INTO membre"
					+ "(nom, prenom, login, mdp, dateNaissance, sex, adresse, mail, fonction, dateInscription ) "
					+ "VALUES"+ "(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepare = connect.prepareStatement(creerMembre);
		    prepare.setString (1, obj.getNom());
		    prepare.setString (2, obj.getPrenom());
		    prepare.setString(3, obj.getLogin());
		    prepare.setString(4, obj.getPassword());
		    prepare.setLong(5, naissance);
		    prepare.setString(6, obj.getSex());
		    prepare.setString(7, obj.getAdresse());
		    prepare.setString(8, obj.getEmail());
		    prepare.setString(9, obj.getFonction());
		    prepare.setLong(10, inscription);
		    prepare.executeUpdate();
		    
		    JOptionPane.showMessageDialog(null, "Le compte a bien été créé, veuillez vous connecter");
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erreur de connection base de donnees : " + e);
			return false;
		} 
		
		return true;
	}
	
	/***
	 * Vérifie si un compte n'existe pas déjà avec ce login ou cet email
	 * @param login
	 * @return
	 */
	public boolean compteExist(String login, String email) {
		try {
			String membre = "SELECT login FROM membre WHERE login = ? OR mail = ?";
			PreparedStatement prepare = connect.prepareStatement(membre);
			prepare.setString (1, login);
			prepare.setString (2, email);
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				return true;
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erreur de connection base de donnees : " + e);
		}
		return false;
	}
	
	@Override
	public boolean delete(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Personne find(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Personne> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
