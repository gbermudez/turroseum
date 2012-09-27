package model;

public class Invento {
	
	private int id;
	private String nombre;
	private int anioI;
	private Inventor[] inventores;
	private String descripcion;
	private boolean isMachine;
	private int periodo;
	private Parte[] partes;
	private PrincipioCientifico[] principios;
	
	public Invento() {
		
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
	public int getAnioI() {
		return anioI;
	}
	public void setAnioI(int anioI) {
		this.anioI = anioI;
	}
	public Inventor[] getInventores() {
		return inventores;
	}
	public void setInventores(Inventor[] inventores) {
		this.inventores = inventores;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isMachine() {
		return isMachine;
	}
	public void setMachine(boolean isMachine) {
		this.isMachine = isMachine;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public Parte[] getPartes() {
		return partes;
	}
	public void setPartes(Parte[] partes) {
		this.partes = partes;
	}
	public PrincipioCientifico[] getPrincipios() {
		return principios;
	}
	public void setPrincipios(PrincipioCientifico[] principios) {
		this.principios = principios;
	}
	public String toString() {
		return nombre;
	}
	

}
