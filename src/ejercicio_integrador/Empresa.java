package ejercicio_integrador;

import java.util.ArrayList;

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
	
	
}
