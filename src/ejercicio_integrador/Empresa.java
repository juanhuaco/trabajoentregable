package ejercicio_integrador;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Empresa {
	ArrayList<Responsable> responsables;
	ArrayList<Proveedor> proveedores;
	ArrayList<Bien> bienes;
	ArrayList<Factura> facturas;
	
	public ArrayList<Responsable> getResponsables() {
		return responsables;
	}
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	public ArrayList<Bien> getBienes() {
		return bienes;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public Empresa(ArrayList<Responsable> responsables, ArrayList<Proveedor> proveedores, ArrayList<Bien> bienes,
			ArrayList<Factura> facturas) {
		super();
		this.responsables = responsables;
		this.proveedores = proveedores;
		this.bienes = bienes;
		this.facturas = facturas;
	}
	
	ArrayList<Factura> listarFacturaByProveedor(Proveedor p){
		ArrayList<Factura> retorno = (ArrayList<Factura>)this.getFacturas().stream()
													   .filter(f -> p.equals(f.getProveedor()))
													   .collect(Collectors.toList());
		return retorno;
	}
	
	ArrayList<Factura> listarFacturaByResponsable(Responsable r){
		ArrayList<Factura> retorno = (ArrayList<Factura>)this.getFacturas().stream()
													   .filter(f -> r.equals(f.getResponsable()))
													   .collect(Collectors.toList());
		return retorno;
	}
	
	ArrayList<String> listarNombresProveedores(Localidad l){
		ArrayList<String> retorno = (ArrayList<String>)this.getProveedores().stream()
													   .filter(p -> p.esDeLocalidad(l))
													   .map(p -> p.getNombre())
													   .sorted()
													   .collect(Collectors.toList());
		return retorno;
	}
	
	ArrayList<Bien> listarBienesByLocalidad(Localidad l){
		ArrayList<Bien> retorno = (ArrayList<Bien>)this.getBienes().stream()
				   .filter(b -> b.getResponsable().esDeLocalidad(l))
				   .collect(Collectors.toList());
		return retorno;
	}

	ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor){
		ArrayList<Bien> retorno = (ArrayList<Bien>)this.getBienes().stream()
				   .filter(b -> b.getPrecio() > precioMayor)
				   .collect(Collectors.toList());
		return retorno;
	}
	
	ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor){
		ArrayList<Factura> retorno = (ArrayList<Factura>)this.getFacturas().stream()
				   .filter(f -> f.getMontoTotal() > montoMayor)
				   .collect(Collectors.toList());
		return retorno;
	}
}
