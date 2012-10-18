import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class SaisirPilote extends JFrame {

	private JPanel pnl_Fenetre;
	private JButton btn_Valider;
	private JLabel lbl_NomPilote;
	private JTextField jtf_NomPilote;
	private JLabel lbl_PrenomPilote;
	private JTextField jtf_PrenomPilote;
	
	public SaisirPilote (){
		
		// On définit les paramètres de base d'une fenêtre :
		this.setTitle("Saisir Pilote - fenêtre java");
		this.setLocation(360, 280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setResizable(false);
		
		// On ajoute le panel à la fenêtre
		pnl_Fenetre = new JPanel();
		this.getContentPane().add(pnl_Fenetre);
		
		btn_Valider = new JButton("Valider");
		lbl_NomPilote = new JLabel(" Nom du Pilote : ");
		jtf_NomPilote = new JTextField();
		lbl_PrenomPilote = new JLabel(" Prénom du Pilote : ");
		jtf_PrenomPilote = new JTextField();
		
		// On ajoute une action au bouton "btn_Valider"
		this.btn_Valider.addActionListener(new btn_valider_action());
		
		// On ajoute dans l'ordre les différents éléments de notre panel
		pnl_Fenetre.add(lbl_NomPilote);
		pnl_Fenetre.add(jtf_NomPilote);
		pnl_Fenetre.add(lbl_PrenomPilote);
		pnl_Fenetre.add(jtf_PrenomPilote);
		pnl_Fenetre.add(btn_Valider);
		
		// On définit une structure pour le panel, ici 4 lignes de 2 colonnes
		pnl_Fenetre.setLayout(new GridLayout(3, 2, 0, 5));
		
		// On rend la fenêtre visible car par défaut elle ne l'est pas
		this.setVisible(true);
	}

	class btn_valider_action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("Valide");
			
			try {
				Connection connexion = DriverManager.getConnection
				("jdbc:postgresql:bdseb", "ssabatier", "noisette");

				Statement unStatement = connexion.createStatement();
				unStatement.executeUpdate("INSERT INTO Pilotes(NomPilote, PrenomPilote) " +
				"VALUES('"+jtf_NomPilote.getText()+"', '"+jtf_PrenomPilote.getText()+"');");
				
				AfficherDonnees informationsPilotes = new AfficherDonnees();
				
				connexion.close();
			}
			catch(SQLException e1){
				System.out.println(e1.getMessage());
			}
	   }
	}
}
