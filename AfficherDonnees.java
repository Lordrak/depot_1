import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AfficherDonnees extends JFrame {
	
	private JTable tbl_Tableau;
	
	public AfficherDonnees(){
		
		// On définit les paramètres de base d'une fenêtre (le titre, la taille...) :
		this.setTitle("AfficherDonnees - fenêtre java");
		this.setLocation(660, 280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setResizable(false);
		
		try {
			Connection connexion = DriverManager.getConnection
			("jdbc:postgresql:bdseb", "ssabatier", "noisette");

			Statement unStatement = connexion.createStatement();
			
			ResultSet chercherTaille = unStatement.executeQuery("SELECT Count(*) FROM Pilotes;");
			chercherTaille.next();
			int taille = chercherTaille.getInt(1);
			
			ResultSet resultat = unStatement.executeQuery("SELECT * FROM Pilotes;");
				
			Object[][] data = new Object[taille][3];
			String[] title = {"Numéro", "Nom", "Prenom"};

			int i = 0;

			while (resultat.next()) {
				
				data[i][0]= resultat.getInt(1);
				data[i][1]= resultat.getString(2);
				data[i][2]= resultat.getString(3); 
				
				i++;
			}

			tbl_Tableau = new JTable(data, title);
		    this.getContentPane().add(new JScrollPane(tbl_Tableau));	
			
		    resultat.close();
		    chercherTaille.close();
			connexion.close();
		}
		catch(SQLException e1){
			System.out.println(e1.getMessage());
		}
		
		// On rend la fenêtre visible car par défaut elle ne l'est pas
		this.setVisible(true);
	}
}
