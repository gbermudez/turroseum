package view;

import controller.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		AltaInventor a = new AltaInventor();
		a.setVisible(true);
		/*
		MySQL db = new MySQL();
		
		
		String query = "SELECT * FROM inventores";
		ResultSet inventores = db.consulta(query);
		ResultSet total;
		
		while (inventores.next()) {
			
			query = "SELECT count(*) FROM relacion_invento_inventor WHERE id_inventor = " + inventores.getInt("id");
			total = db.consulta(query);
			total.next();
			System.out.println("El inventor " + inventores.getString("nombre") + " tiene " + total.getInt(1) + " inventos");
		
		}
		
		db.cerrar();
		
		*/
	}

}
