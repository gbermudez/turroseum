package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class MySQL {
 
Connection conexion = null;
 
	//Datos de conexion
	public String bd = "museo";
	public String user = "root";
	public String pass = "3487";
	public String url = "jdbc:mysql://localhost/"+bd;
	 
	//Contructor
	public MySQL() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	 
		try {
			//Creando Instancia del driver
			java.lang.Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Conectando con los datos de conexión
			this.conexion = DriverManager.getConnection(url,user,pass); 
	      
			System.out.println("Se ha conectado con exito!!!");
	 
	    } 
		catch (SQLException ex) {
			//Mostrar errores
			System.out.println("Problemas al conectar con MySQL con base de datos :"+bd);
			System.out.println("SQLException : " + ex.getMessage());
			System.out.println("SQLState : " + ex.getSQLState());
			System.out.println("VendorError : " + ex.getErrorCode());
	    }
	 
	}
	 
	//Metodo realiza consultas
	public ResultSet consulta(String SQL) throws SQLException {
		//Creamos un tipo Statement que maneja las consultas 
		Statement s = this.conexion.createStatement();
		return  s.executeQuery (SQL);
	}
	 
	public void cerrar() throws SQLException {
		this.conexion.close();
	}
}