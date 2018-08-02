package be.Denis.Vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profil extends JPanel {
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public Profil() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		
		lblNewLabel = new JLabel("Profil");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(192, 32, 62, 44);

		
		btnNewButton = new JButton("Test");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Test");
			}
		});
		btnNewButton.setBounds(150, 202, 100, 100);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		add(lblNewLabel);
		add(btnNewButton);

	}
	
	

}
