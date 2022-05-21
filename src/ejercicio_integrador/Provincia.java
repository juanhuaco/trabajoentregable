package ejercicio_integrador;

import java.util.Objects;

public class Provincia extends Ubicacion {

	private Pais pais;
	
	
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public Provincia(String nombre, Pais pais) {
		super(nombre);
		this.pais = pais;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return Objects.equals(this.getNombre(), other.getNombre())
			&& this.pais.equals(other.getPais());
	}
	
	
}
