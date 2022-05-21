package ejercicio_integrador;

import java.util.ArrayList;

public class Proveedor extends Persona {
	private ArrayList<Bien> bienes;
	
	public ArrayList<Bien> getBienes() {
		return bienes;
	}
	public void setBienes(ArrayList<Bien> bienes) {
		this.bienes = bienes;
	}
	
	
	public Proveedor(String nombre, Localidad localidad, ArrayList<Bien> bienes) {
		super(nombre, localidad);
		this.bienes = bienes;
	}
	
	
}
