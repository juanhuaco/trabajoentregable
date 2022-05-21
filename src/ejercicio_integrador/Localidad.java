package ejercicio_integrador;

import java.util.Objects;

public class Localidad extends Ubicacion{
	
	private Provincia provincia;

	
	

	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
	
	public Localidad(String nombre, Provincia provincia, Pais pais) {
		super(nombre);
		this.provincia = provincia;
	
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		return Objects.equals(this.getNombre(), other.getNombre())
			&& this.provincia.equals(other.getProvincia());
	}
	
	
}
