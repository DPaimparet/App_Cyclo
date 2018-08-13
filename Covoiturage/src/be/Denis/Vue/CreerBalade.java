package be.Denis.Vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import be.Denis.Model.Responsable;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreerBalade extends JPanel {
	
	private JPanel formBalade;
	private JTextField textFieldLieu;
	private JTextField textFieldForfait;
	private JDateChooser dateChooser;
	
	/**
	 * Create the panel.
	 */
	public CreerBalade(Responsable responsable) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0,0,800,800);
		setLayout(new BorderLayout(0, 0));
		
		formBalade = new JPanel();
		formBalade.setBackground(Color.DARK_GRAY);
		formBalade.setBounds(0,0,800,800);
		formBalade.setLayout(null);
		add(formBalade);
		
		JLabel lblTitre = new JLabel("Nouvelle Balade");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setBounds(315, 64, 170, 50);
		formBalade.add(lblTitre);
		
		JLabel lblLieu = new JLabel("Lieu");
		lblLieu.setForeground(Color.WHITE);
		lblLieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLieu.setBounds(242, 149, 35, 14);
		formBalade.add(lblLieu);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(242, 214, 35, 14);
		formBalade.add(lblDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(468, 208, 150, 20);
		formBalade.add(dateChooser);
		
		textFieldLieu = new JTextField();
		textFieldLieu.setBounds(468, 148, 150, 20);
		formBalade.add(textFieldLieu);
		textFieldLieu.setColumns(10);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setForeground(Color.WHITE);
		lblInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformation.setBounds(242, 279, 99, 14);
		formBalade.add(lblInformation);
		
		JTextArea txtrInfo = new JTextArea();
		txtrInfo.setText("Heure de d\u00E9part :\r\n\r\nInformation de la balade");
		txtrInfo.setBounds(242, 312, 376, 250);
		formBalade.add(txtrInfo);
		
		JLabel lblForfait = new JLabel("Forfait");
		lblForfait.setForeground(Color.WHITE);
		lblForfait.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForfait.setBounds(242, 609, 99, 14);
		formBalade.add(lblForfait);
		
		textFieldForfait = new JTextField();
		textFieldForfait.setColumns(10);
		textFieldForfait.setBounds(468, 608, 150, 20);
		formBalade.add(textFieldForfait);
		
		JButton btnCreerBalade = new JButton("Cr\u00E9er la balade");
		btnCreerBalade.setBackground(new Color(241, 57, 83));
		btnCreerBalade.setForeground(Color.WHITE);
		btnCreerBalade.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreerBalade.setBounds(300, 700, 200, 30);
		formBalade.add(btnCreerBalade);
		
		btnCreerBalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				responsable.creerBalade(textFieldLieu.getText(), dateChooser.getDate(), txtrInfo.getText(), Float.valueOf(textFieldForfait.getText()));
			}
		});
		
	}
}
