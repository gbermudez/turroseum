package model;

public class Inventor {
	
	private int id;
	private String nombre;
	private int anioN;
	private String lugarN;
	
	public Inventor() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnioN() {
		return anioN;
	}
	public void setAnioN(int anioN) {
		this.anioN = anioN;
	}
	public String getLugarN() {
		return lugarN;
	}
	public void setLugarN(String lugarN) {
		this.lugarN = lugarN;
	}
	public String toString() {
		return nombre;
	}

}
