package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.PreparedStatement;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

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
	public ArrayList<Parte> getPartes(int id) throws SQLException {
		ArrayList<Parte> partes = new ArrayList<Parte>();
		
		String query = "SELECT * FROM parte_invento WHERE invento = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		ResultSet rs = s.executeQuery();
		ResultSet rs2;
		while (rs.next()) {
			query = "SELECT * FROM partes WHERE id = "+rs.getInt(1);
			s = this.con.prepareStatement(query);
			rs2 = s.executeQuery();
			while (rs2.next()) {
				Parte p = new Parte();
				p.setId(rs2.getInt("id"));
				p.setNombre(rs2.getString("nombre"));
				p.setDescripcion(rs2.getString("descripcion"));
				partes.add(p);
			}
		}
		return partes;
	}
	
	public ArrayList<Principio> getPrincipios(int id) throws SQLException {
		ArrayList<Principio> principios = new ArrayList<Principio>();
		
		String query = "SELECT * FROM principio_invento WHERE invento = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		ResultSet rs = s.executeQuery();
		ResultSet rs2;
		while (rs.next()) {
			query = "SELECT * FROM principios WHERE id = "+rs.getInt(1);
			s = this.con.prepareStatement(query);
			rs2 = s.executeQuery();
			while (rs2.next()) {
				Principio p = new Principio();
				p.setId(rs2.getInt("id"));
				p.setNombre(rs2.getString("nombre"));
				p.setDescripcion(rs2.getString("descripcion"));
				p.setImagen(rs2.getBytes("imagen"));
				principios.add(p);
			}
		}
		return principios;
	}
	
	public ImageIcon getImagen(int id) throws SQLException, IOException {
		String query = "SELECT * FROM principios WHERE id = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		ResultSet rs = s.executeQuery();
		rs.next();
		Image imagen;
		Blob img = rs.getBlob("imagen");
        imagen = javax.imageio.ImageIO.read(img.getBinaryStream());
        ImageIcon image = new ImageIcon(imagen);
        return image;
		
	}

	public ArrayList<Invento> getMaquinasRelacionadas(int id) throws SQLException {
		ArrayList<Invento> inventos = new ArrayList<Invento>();
		String query = "SELECT * FROM principio_invento WHERE invento = ?";
		PreparedStatement s = this.con.prepareStatement(query);
		s.setInt(1, id);
		ResultSet rs = s.executeQuery();
		
		ResultSet rs2 = null;
		
		
		while (rs.next()) {
			query = "SELECT * FROM principio_invento WHERE principio = "+rs.getInt("principio");
			s = this.con.prepareStatement(query);
			rs2 = s.executeQuery();
		}
		ResultSet rs3 = null;
		
		while(rs2.next()) {
			query = "SELECT * FROM inventos WHERE id = "+rs2.getInt("invento");
			s = this.con.prepareStatement(query);
			rs3 = s.executeQuery();
			while (rs3.next()) {
				if (rs3.getInt("id") != id) {
					Invento i = new Invento();
					i.setId(rs3.getInt("id"));
					i.setNombre(rs3.getString("nombre"));
					i.setDescripcion(rs3.getString("descripcion"));
					i.setPeriodo(this.getPeriodo(rs3.getInt("periodo")));
					inventos.add(i);
				}
			}
		}
		
		return inventos;
		}
	
	
	
}
