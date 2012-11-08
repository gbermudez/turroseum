package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
			System.out.println("MAL");

			return false;
		}
	}
	
	public boolean agregarInventor(String nombre, int anio, String lugar) throws SQLException {
		String query = "INSERT INTO inventores (nombre, anioI, lugarN) VALUES (?, ?, ?)";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setString(1, nombre);
		s.setInt(2, anio);
		s.setString(3, lugar);
		;
		if (s.executeUpdate() != 0) { 
			System.out.println("OK");
			return true;
		}
		else {
			System.out.println("MAL");

			return false;
		}
	}
	
	public ResultSet getInvento(String id, boolean todos) throws SQLException {
		if (todos){
			String query = "SELECT * FROM inventos";
			PreparedStatement s = this.con.prepareStatement(query);
			ResultSet inventos = s.executeQuery();
			return inventos;

		}
		else {
			return null;
		}	
	}
	
	
	public ResultSet getInventor(String id, boolean todos) throws SQLException {
		if (todos){
			String query = "SELECT * FROM inventores";
			PreparedStatement s = this.con.prepareStatement(query);
			ResultSet inventores = s.executeQuery();
			return inventores;

		}
		else {
			return null;
		}	
	}
	
	public Periodo getPeriodo(int id) throws SQLException {
			String query = "SELECT * FROM periodos WHERE id ="+ id;
			PreparedStatement s = this.con.prepareStatement(query);
			ResultSet rs = s.executeQuery();
			rs.next();
			Periodo p = new Periodo();
			p.setId(rs.getInt(1));
			p.setNombre(rs.getString(2));
			return p;
	}	
	
	public ArrayList<Inventor> getInventoresByInvento(int id) throws SQLException {
		ArrayList<Inventor> inventores = new ArrayList<Inventor>();
		String query = "SELECT * FROM inventor_invento WHERE invento = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		ResultSet rs = s.executeQuery();
		ResultSet rs2;
		while (rs.next()) {
			query = "SELECT * FROM inventores WHERE id = "+rs.getInt(1);
			s = this.con.prepareStatement(query);
			rs2 = s.executeQuery();
			while (rs2.next()) {
				Inventor i = new Inventor();
				i.setId(rs2.getInt("id"));
				i.setNombre(rs2.getString("nombre"));
				i.setAnioN(rs2.getInt("anioI"));
				i.setLugarN(rs2.getString("lugarN"));
				inventores.add(i);
			}
		}
		return inventores;
	}
	
	public void sumarVista(int id) throws SQLException {
		String query = "UPDATE inventos SET vistas = vistas+1 WHERE id = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		int rs = s.executeUpdate();
	}
	
	public void sumarVoto(int id) throws SQLException {
		String query = "UPDATE inventos SET votos = votos+1 WHERE id = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		int rs = s.executeUpdate();
	}
	
	public ResultSet getInventosSimilares(int periodo, int id) throws SQLException {

		String query = "SELECT * FROM inventos WHERE periodo = ? AND id != ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, periodo);
		s.setInt(2, id);
		ResultSet rs = s.executeQuery();
		return rs;
		
	}
	
	public ResultSet getInventoresContemporaneos(int id, int anio) throws SQLException {
		int menos = anio-10;
		int mas = anio+10;
		String query = "SELECT * FROM inventores WHERE id != ? AND anioI BETWEEN ? AND ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		s.setInt(2, menos);
		s.setInt(3, mas);
		ResultSet rs = s.executeQuery();
		return rs;	
	}
	
	
}
