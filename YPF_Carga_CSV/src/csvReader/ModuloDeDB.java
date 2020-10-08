package csvReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModuloDeDB {
	
	public static void main(String[] args) {

	        // Create a variable for the connection string.
	        String connectionUrl = "jdbc:sqlserver://DESKTOP-DN3QN3D\\SQLEXPRESS;user=max;password=123456;databaseName=CC_Cubo;";

	        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
	            String SQL = "SELECT  * FROM hora_dia";
	            ResultSet rs = stmt.executeQuery(SQL);

	            // Iterate through the data in the result set and display it.
	            while (rs.next()) {
	                System.out.println(rs.getString("id_dia_semana") + " " + rs.getString("id_hora_dia"));
	            }
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


}
