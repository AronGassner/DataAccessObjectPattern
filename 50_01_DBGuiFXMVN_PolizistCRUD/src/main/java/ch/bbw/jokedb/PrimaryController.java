package ch.bbw.jokedb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author Peter Rutschmann
 * @date 03.07.2020
 */
public class PrimaryController {
	@FXML
	private Label lblOut;

	@FXML
	private TextField txtFldName;

	@FXML
	private TextField txtFldVorname;

	@FXML
	private TextField txtFldUpdateID;
	
	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary");
	}

	@FXML
	private void listEntities() throws IOException {
		String output = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/autobahnpolizei";
			Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

			Statement stmt = connection.createStatement();
			ResultSet entries = stmt.executeQuery("SELECT * FROM polizist");

			while (entries.next()) {
				Polizist polizist = new Polizist(
						entries.getInt("PolizistID"),
						entries.getString("Name"),
						entries.getString("Vorname"),
						entries.getInt("GruppeIDFS"),
						entries.getInt("PartnerPolizistIDFS"));
						
				output = output + polizist + "\n";
			}

			// alle verwendeten Objekte schliessen
			entries.close();
			stmt.close();
			connection.close();
			
			lblOut.setText(output);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@FXML
	private void addNewEntity() throws IOException {
		if(txtFldName.getText().isEmpty() || txtFldVorname.getText().isEmpty()) {
			System.err.println("addNewEntity: Failed, a field is empty");
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/autobahnpolizei";
			Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

			//Ab hier ergänzen
			String sql = " HIER SQL ERGAENZEN ";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			
			// alle verwendeten Objekte schliessen
			stmt.close();
			connection.close();
			
			lblOut.setText("Polizist erstellt: " + txtFldName.getText());
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void updateEntity() throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/autobahnpolizei";
			Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

			//Ab hier ergänzen
			String sql = " HIER SQL ERGAENZEN ";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			// alle verwendeten Objekte schliessen
			stmt.close();
			connection.close();
			
			lblOut.setText("Polizist verändert: " + txtFldUpdateID.getText());

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void deleteEntity() throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/autobahnpolizei";
			Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

			//Ab hier ergänzen
			String sql = " HIER SQL ERGAENZEN ";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			
			// alle verwendeten Objekte schliessen
			stmt.close();
			connection.close();
			
			lblOut.setText("Polizist gelöscht: " + txtFldUpdateID.getText());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
