package view;

import controller.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		MySQL db = new MySQL();
		
		String query = "SELECT * FROM porno";
		
		ResultSet rs = db.consulta(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("nombre"));
		}
		
		db.cerrar();
		
		
	}

}
