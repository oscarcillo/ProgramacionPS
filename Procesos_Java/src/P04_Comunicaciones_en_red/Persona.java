package P04_Comunicaciones_en_red;

import java.io.Serializable;

public class Persona implements Serializable{
	
	String nombre;
	int edad;

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	//
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
