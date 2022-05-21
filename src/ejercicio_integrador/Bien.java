package ejercicio_integrador;

public class Bien {
	static private int _id = 1;
	private int id;
	private String alias;
	private String descripcion;
	private double precio;
	private Responsable responsable;
	

	public int getId() {
		return id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	
	
	public Bien(String alias, String descripcion, double precio, Responsable responsable) {
		super();
		this.id = Bien._id;
		Bien._id++;
		this.alias = alias;
		this.descripcion = descripcion;
		this.precio = precio;
		this.responsable = responsable;

	}


	

}
