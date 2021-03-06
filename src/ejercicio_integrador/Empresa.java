package ejercicio_integrador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.*;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

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
	
	ArrayList<String> listarFactuadasPorProveedor(Proveedor p){
		String format = "dd/MM/yyyy";
		DateFormat df = new SimpleDateFormat(format);
		
		ArrayList<Factura> facturass = this.listarFacturaByProveedor(p);
		Collections.sort(facturass, new CompararFacturaPorFecha());
		ArrayList<String> retorno = (ArrayList<String>)facturass.stream()
				.map(f -> "En la fecha " + df.format(f.getFecha()) + ", " + f.getProveedor().getNombre() + " factur? con un total de $" + f.getMontoTotal() + " con " + f.getBienes().size() + " bienes")
				.collect(Collectors.toList());
		
		return retorno;
	}
	
	
	
}
