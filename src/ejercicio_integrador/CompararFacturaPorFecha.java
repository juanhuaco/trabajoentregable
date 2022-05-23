package ejercicio_integrador;

import java.util.Comparator;
import java.util.Date;

public class CompararFacturaPorFecha implements Comparator<Factura>{
	
	public CompararFacturaPorFecha() {
		super();
	}

	@Override
	public int compare(Factura f1, Factura f2) {
		// TODO Auto-generated method stub
		int ret = f1.getFecha().compareTo(f2.getFecha());
		if(ret == 0) return 0;
		else if(ret < 0) return 1;
		else return -1;
	}
	
	
}
