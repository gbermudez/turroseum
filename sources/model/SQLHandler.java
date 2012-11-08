package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import controller.MD5;

public class SQLHandler {
	
	private Connection con;
	
	public SQLHandler() {
		this.con = MySQL.getConnection();
	}

	public boolean loguear(String user, String pass) throws SQLException {
		
		pass = MD5.encriptar(pass);
		
		String query = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setString(1, user);
		s.setString(2, pass);
		ResultSet rs = s.executeQuery();
		if (rs.first()) { 
			System.out.println("OK");
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
}
