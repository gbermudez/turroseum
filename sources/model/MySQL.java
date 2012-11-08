package model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQL{	
	
	//INSTANCIA ESTATICA UNA SOLA EXITE.
	private static Connection connection = null;		
	
	//Devuelvo una sola instancia de la conexion
	public static Connection getConnection(){		
		//Si no hay instancia la creo
		if(MySQL.connection == null){
			initConnection();
		}
		return MySQL.connection;
	}	
	//Traigo instancia
	private static void initConnection(){			
		try{		
			Class.forName("com.mysql.jdbc.Driver");		
			String db = "museo";
			String url = "jdbc:mysql://localhost/"+db;
			String user = "root";
			String pw = "3487";
			MySQL.connection = (Connection) DriverManager.getConnection(url, user, pw);		
		}
		catch (ClassNotFoundException e){		
			System.out.println(e.getMessage());
			System.exit(0);
		}
		catch (SQLException e){			
			System.out.println(e.getMessage());
			System.exit(0);
		}
		catch (Exception e){		
		}		
	}
}





	
