package ejercicio_integrador;

import java.util.Objects;

public class Pais extends Ubicacion {
	public Pais(String nombre) {
		super(nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(this.getNombre(), other.getNombre());
	}
	
	
}
