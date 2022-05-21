package ejercicio_integrador;

public abstract class Persona implements CriterioBusqueda<Localidad>{
	static private int _id = 1;
	private int id;
	private String nombre;
	private Localidad localidad;
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	public boolean mismaLocalidad(Persona p) {
		//return this.getLocalidad().getId() == p.getLocalidad().getId(); 
		return this.esDeLocalidad(p.getLocalidad());
	}
	
	public boolean mismaProvincia(Persona p) {
		return this.getLocalidad().getProvincia().getId() == p.getLocalidad().getProvincia().getId();
	}
	
	public boolean mismoPais(Persona p) {
		return this.getLocalidad().getProvincia().getPais().getId() == p.getLocalidad().getProvincia().getPais().getId();
	}
	
	public boolean esDeLocalidad(Localidad l) {
		return this.localidad.equals(l);
	}
	
 	public Persona(String nombre, Localidad localidad) {
		super();
		this.id = Persona._id;
		Persona._id++;
		this.nombre = nombre;
		this.localidad = localidad;
	}
	
	
	
	
}
