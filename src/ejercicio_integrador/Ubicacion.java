package ejercicio_integrador;

import java.util.Objects;

public abstract class Ubicacion {
	static private int _id = 1;
	private int id;
	private String nombre;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public Ubicacion(String nombre) {
		super();
		this.id = Ubicacion._id;
		Ubicacion._id++;
		this.nombre = nombre;
	}

	@Override
	public abstract boolean equals(Object obj); 
	
}
