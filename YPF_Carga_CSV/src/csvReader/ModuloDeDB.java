package csvReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModuloDeDB {
	
	public static void main(String[] args) {
		
		ConexionSQL conexion = new ConexionSQL ();
		Connection cm = null;
		Statement scm = null;
		
		ResultSet rs = null;
		
		
		try 
		{
			cm = conexion.conectar();
			scm = cm.createStatement();
			
			rs= scm.executeQuery("SELECT * FROM dim_criticidad");
			
			
			while (rs.next())
			{
				String aaa = rs.getString(1);
				
				System.out.println(aaa);
			} 
				
						
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
