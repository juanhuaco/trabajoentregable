package ejercicio_integrador;

public class Responsable extends Persona{
	private String oficina;
	
	
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	
	
	public Responsable(String nombre, Localidad localidad, String oficina) {
		super(nombre, localidad);
		this.oficina = oficina;
	}

	
	

}
